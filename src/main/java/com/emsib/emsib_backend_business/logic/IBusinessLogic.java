package com.emsib.emsib_backend_business.logic;

import java.util.ArrayList;

import com.emsib.emsib_backend_business.logic.dto.BuildingDto;
import com.emsib.emsib_backend_business.logic.dto.UserDto;

public interface IBusinessLogic {
    public String getReport(String s);
    public String getSummary(String s);
    public String getAlert(String s);
    public ArrayList<UserDto> getUsersData();
    public UserDto getUserData(int id);
    public void setUserData(UserDto u);
    public ArrayList<BuildingDto> getBuildingsData();
    public BuildingDto getBuildingData(int id);
    public void setBuildingData(BuildingDto u);
    public int checkAuth(String l, String p);
    public IBusinessLogic createBusinessLogic();
}
