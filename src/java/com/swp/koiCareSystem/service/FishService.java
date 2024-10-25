/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.koiCareSystem.service;

import com.swp.koiCareSystem.dao.FishDAO;
import com.swp.koiCareSystem.model.Fish;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FishService {

    private FishDAO fishDAO;

    public FishService() {
        fishDAO = new FishDAO();
    }

    public int countAllFishByIdS(int id) {
        return fishDAO.countFishs(id);
    }

    public ArrayList<Fish> getFishsbById(int id, int index) {
        ArrayList<Fish> list = fishDAO.getFishsByAccID(id, index);
        return list;
    }

    public ArrayList<Fish> getAllFishS(int accountID) {
        return fishDAO.getAllFish(accountID);

    }

    public Fish getFishInforByIDS(int id) {
        return fishDAO.getFishInforByID(id);
    }

    public Fish getFishDetailByIDS(int id) {
        return fishDAO.getFishDetailByFishID(id);
    }

    public boolean updateFishImageByPondId(int pid, String imgLink) {
        return fishDAO.updateFishImageByFishID(pid, imgLink);
    }

    public boolean addNewFish(Fish f) {
        if (f.getFishImage() == null || f.getFishImage().isEmpty()) {
            f.setFishImage("https://plus.unsplash.com/premium_photo-1723672584731-52b5f1a67543?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8a29pJTIwZmlzaHxlbnwwfHwwfHx8MA%3D%3D");
        }
        if (f.getPondID() > 0) {
            PondService psv = new PondService();
            int quantityFishInPond = psv.getNumberFishInPond(f.getPondID());
            quantityFishInPond += 1;
            boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, f.getPondID());
            if (!isUpdateQuantity) {
                return false;
            }
        }
        return fishDAO.addNewFish(f);
    }

    public boolean deletFishByID(String fishId, int pondId) {
//       pond ID > 0 vi khi xoa ca neu ca o trang thai ko co pond thi co the xoa ma ko phai decrease quantityFish in pond
        if (pondId > 0) {
            PondService psv = new PondService();
            int quantityFishInPond = psv.getNumberFishInPond(pondId);
            quantityFishInPond -= 1;
            boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, pondId);
            if (!isUpdateQuantity) {
                return false;
            }
        }
        return fishDAO.deleteFishByID(fishId);
    }

    public boolean updateFishInformationByID(Fish f, int oldPondId) {
        PondService psv = new PondService();
        boolean isExistFishInPond = true;
        if (oldPondId == 0) {
            if (f.getPondID() > 0) {
//                Check coi la new pond have fish or not
                isExistFishInPond = fishDAO.checkFishIsExistInPondById(f.getFishID(), f.getPondID());
                if (isExistFishInPond) {
                    return false;
                } else {
                    int quantityFishInPond = psv.getNumberFishInPond(f.getPondID());
                    quantityFishInPond += 1;
                    boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInPond, f.getPondID());
                    if (!isUpdateQuantity) {
                        return false;
                    }
                }
            }
        } else {
            if (f.getPondID() == 0) { //From old pond -> to Unassigned
                // check xem old pond co fish do ko
                isExistFishInPond = fishDAO.checkFishIsExistInPondById(f.getFishID(), oldPondId);
                if (isExistFishInPond) {
                    int quantityFishInOldPond = psv.getNumberFishInPond(oldPondId); // lay cai quantity old pond khi chuyen
                    quantityFishInOldPond -= 1;
                    boolean isUpdateQuantity = psv.updateNumberFishInPond(quantityFishInOldPond, oldPondId);
                    if (!isUpdateQuantity) {
                        return false;
                    }
                } else {
                    return false;
                }

            } else if (f.getPondID() != oldPondId) {
                // Check coi ho cun con fish ton tai ko
                isExistFishInPond = fishDAO.checkFishIsExistInPondById(f.getFishID(), oldPondId);
                if (isExistFishInPond) {
// Decrease quantity of fish in old pond                
                    int quantityFishInOldPond = psv.getNumberFishInPond(oldPondId);
                    quantityFishInOldPond -= 1;
                    if (quantityFishInOldPond < 0) {
                        return false;
                    }
                    boolean isUpdateQuantityOld = psv.updateNumberFishInPond(quantityFishInOldPond, oldPondId);
                    if (!isUpdateQuantityOld) {
                        return false;
                    }
// Increase quantity of fish in old pond              
                    int quantityNewPond = psv.getNumberFishInPond(f.getPondID());
                    quantityNewPond += 1;
                    boolean isUpdateQuantityNew = psv.updateNumberFishInPond(quantityNewPond, f.getPondID());
                    if (!isUpdateQuantityNew) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return fishDAO.updateFishInformationByID(f);
    }

    public int countFishInPondByPondId(int pondID) {
        return fishDAO.countFishInPondByPondId(pondID);
    }

    public boolean checkFishExist(int fishId) {
        return fishDAO.checkFishIsExist(fishId);
    }

}
