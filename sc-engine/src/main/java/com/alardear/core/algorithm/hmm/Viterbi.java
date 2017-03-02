package com.alardear.core.algorithm.hmm;

/**
 * 隐马尔科夫 Viterbi算法实现
 * 
 * @see https://github.com/hankcs/Viterbi
 *
 */
public class Viterbi {

	/**
	 * 求解HMM模型
	 * 
	 * @param obs		观测序列
	 * @param states 	隐状态
	 * @param start_p 	初始概率（隐状态）
	 * @param trans_p 	转移概率（隐状态）
	 * @param emit_p 	发射概率 （隐状态表现为显状态的概率）
	 * @return 最可能的序列
	 */
	public static int[] compute(int[] obs, int[] states, double[] start_p, double[][] trans_p, double[][] emit_p) {
		double[][] V = new double[obs.length][states.length];
		int[][] path = new int[states.length][obs.length];

		for (int y : states) {
			V[0][y] = start_p[y] * emit_p[y][obs[0]];
			path[y][0] = y;
		}

		for (int t = 1; t < obs.length; ++t) {
			int[][] newpath = new int[states.length][obs.length];

			for (int y : states) {
				double prob = -1;
				int state;
				for (int y0 : states) {
					double nprob = V[t - 1][y0] * trans_p[y0][y] * emit_p[y][obs[t]];
					if (nprob > prob) {
						prob = nprob;
						state = y0;
						// 记录最大概率
						V[t][y] = prob;
						// 记录路径
						System.arraycopy(path[state], 0, newpath[y], 0, t);
						newpath[y][t] = y;
					}
				}
			}

			path = newpath;
		}

		double prob = -1;
		int state = 0;
		for (int y : states) {
			if (V[obs.length - 1][y] > prob) {
				prob = V[obs.length - 1][y];
				state = y;
			}
		}

		return path[state];
	}
	
	static enum Weather{
        Rainy,
        Sunny,
    }
    static enum Activity{
        walk,
        shop,
        clean,
    }
	
    /**
     * 经典的天气demo
     * @param args
     */
	public static void main(String[] args) {
	    int[] states = new int[]{Weather.Rainy.ordinal(), Weather.Sunny.ordinal()};
	    int[] observations = new int[]{Activity.walk.ordinal(), Activity.shop.ordinal(), Activity.clean.ordinal()};
	    double[] start_probability = new double[]{0.6, 0.4};
	    double[][] transititon_probability = new double[][]{
	            {0.7, 0.3},
	            {0.4, 0.6},
	    };
	    double[][] emission_probability = new double[][]{
	            {0.1, 0.4, 0.5},
	            {0.6, 0.3, 0.1},
	    };
	    int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result){
            System.out.print(Weather.values()[r] + " ");
        }
        System.out.println();
	}
}
