package com.emsib.emsib_backend_business.logic;

import java.util.ArrayList;

public interface IBusinessLogic {
    public String getReport(String s);
    public String getSummary(String s);
    public String getAllert(String s);
    public ArrayList<User> getUsersData();
    public User getUserData(int id);
    public void setUserData(User u);
    public ArrayList<Building> getBuildingsData();
    public Building getBuildingData(int id);
    public void setBuildingData(Building u);
    public int checkAuth(String l, String p);
    public IBusinessLogic createBusinessLogic();
}
