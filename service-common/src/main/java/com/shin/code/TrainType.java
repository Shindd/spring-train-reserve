package com.shin.code;

/**
 * Types of train to treat
 */
public enum TrainType {
	
	KTX("ktx"),
	SRT("srt");
	
	private String trainName;
	
	TrainType(String trainName) {
		this.trainName = trainName;
	}
}
