/**
 * 
 */
package com.poc.vz.response;

import java.util.List;

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
	private List<Recommendation> recommendations;

	public Recommendation getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Recommendation recommendation) {
		this.recommendation = recommendation;
	}

	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	
}
