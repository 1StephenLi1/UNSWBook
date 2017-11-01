package unswbook.beans;

import java.sql.Timestamp;

public class FriendShip {
	private int id;
	private int friend1Id;
	private int friend2Id;
	private Timestamp applyTime;	//time when sending friend request
	private Timestamp startTime;	//time when friendship starts
	private boolean currentState;	//'0' for waiting response, '1' for accepted
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFriend1Id() {
		return friend1Id;
	}
	public void setFriend1Id(int friend1Id) {
		this.friend1Id = friend1Id;
	}
	public int getFriend2Id() {
		return friend2Id;
	}
	public void setFriend2Id(int friend2Id) {
		this.friend2Id = friend2Id;
	}
	public Timestamp getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public boolean isCurrentState() {
		return currentState;
	}
	public void setCurrentState(boolean currentState) {
		this.currentState = currentState;
	}
	
	
}
