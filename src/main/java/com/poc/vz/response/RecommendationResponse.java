/**
 * 
 */
package com.poc.vz.response;

import com.poc.vz.model.Recommendation;

/**
 * @author ranjit.soni
 *
 */
public class RecommendationResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Recommendation recommendation;

	public Recommendation getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}
	
}
