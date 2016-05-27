package com.fms.model.facility;

public class FacilityDetails {
	
	private boolean isAvailable;
	private boolean isBuilding;
	private boolean isInUseNow;
	
	private int capacity;
	private int facilityID;
	private int floorNumb;
	private int roomNumb;
	
	private String facilityDetail;
	private String facilityName;
	
	private AddressDetails facilityAddress;
	private BuildingDetails buildingDetails;
	
	
	

	public FacilityDetails() {
		super();
	}

	public FacilityDetails(boolean isAvailable, boolean isBuilding,
			boolean isInUseNow, int capacity, BuildingDetails buildingDetails, int facilityID,
			int floorNumb, int roomNumb, AddressDetails facilityAddress,
			String facilityDetail, String facilityName) {
		super();
		this.isAvailable = isAvailable;
		this.isBuilding = isBuilding;
		this.isInUseNow = isInUseNow;
		this.capacity = capacity;
		this.setBuildingDetails(buildingDetails);
		this.facilityID = facilityID;
		this.floorNumb = floorNumb;
		this.roomNumb = roomNumb;
		this.facilityAddress = facilityAddress;
		this.facilityDetail = facilityDetail;
		this.facilityName = facilityName;
	}

	public FacilityDetails(boolean isAvailable, boolean isBuilding,
			int capacity, BuildingDetails buildingDetails, int floorNumb, int roomNumb,
			AddressDetails facilityAddress, String facilityName) {
		super();
		this.isAvailable = isAvailable;
		this.isBuilding = isBuilding;
		this.isInUseNow = false;
		this.capacity = capacity;
		this.setBuildingDetails(buildingDetails);
		this.floorNumb = floorNumb;
		this.roomNumb = roomNumb;
		this.facilityAddress = facilityAddress;
		this.facilityName = facilityName;
	}
	
	public void displayFacilityDetails(){
		System.out.println("FACILITY ID : \"" + getFacilityID() 
						+ "\", FACILITY NAME : \"" + getFacilityName() 
						+ "\", FLOOR NO. : \"" + getFloorNumb()
						+ "\", ROOM NO. : \"" + getRoomNumb()
						+ "\"CAPACITY : \"" + getCapacity()
						+ "\"FACILITY AVAILABILITY : \"" + isAvailable()
						+ "\"BUILDING OR ROOM : \"" + isBuilding());
	}
	
	
	
	public String getFacilityDetail() {
		return facilityDetail;
	}

	public void setFacilityDetail(String facilityDetail) {
		this.facilityDetail = facilityDetail;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setBuilding(boolean isBuilding) {
		this.isBuilding = isBuilding;
	}
	
	public void setIsBuilding(boolean isBuilding) {
		this.isBuilding = isBuilding;
	}

	public void setInUseNow(boolean isInUseNow) {
		this.isInUseNow = isInUseNow;
	}
	
	public void setIsInUseNow(boolean isInUseNow) {
		this.isInUseNow = isInUseNow;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setFloorNumb(int floorNumb) {
		this.floorNumb = floorNumb;
	}
	
	public void setRoomNumb(int roomNumb) {
		this.roomNumb = roomNumb;
	}

	public void setFacilityAddress(AddressDetails facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public boolean isBuilding() {
		return isBuilding;
	}
	
	public boolean getIsBuilding() {
		return isBuilding;
	}
	
	public boolean isInUseNow() {
		return isInUseNow;
	}
	
	public boolean getIsInUseNow() {
		return isInUseNow;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public int getFloorNumb() {
		return floorNumb;
	}

	public int getRoomNumb() {
		return roomNumb;
	}

	public AddressDetails getFacilityAddress() {
		return facilityAddress;
	}
	
	public String getFacilityName() {
		return facilityName;
	}

	public BuildingDetails getBuildingDetails() {
		return buildingDetails;
	}

	public void setBuildingDetails(BuildingDetails buildingDetails) {
		this.buildingDetails = buildingDetails;
	}
	
	
}
