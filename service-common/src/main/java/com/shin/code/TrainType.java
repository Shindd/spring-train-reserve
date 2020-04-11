package com.shin.code;

/**
 * 기차 종류
 */
public enum TrainType {
	
	KTX("ktx"),
	SRT("srt");
	
	private String trainName;
	
	TrainType(String trainName) {
		this.trainName = trainName;
	}
}
