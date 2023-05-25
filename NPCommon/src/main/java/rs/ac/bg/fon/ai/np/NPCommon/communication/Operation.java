package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

public enum Operation  implements Serializable{
    LOGIN,
    GET_ALL_DRIVERS,
    GET_ALL_TRUCKS,
    GET_ALL_MANUFACTURERS,
    GET_ALL_TRUCK_TYPES,
    GET_DRIVERS,
    GET_TRUCKS,
    GET_LOADS,
    GET_TRUCK_MAINTENANCES,
    SAVE_DRIVER,
    SAVE_TRUCK,
    SAVE_LOAD,
    EDIT_DRIVER,
    EDIT_TRUCK,
    EDIT_LOAD,
    DELETE_DRIVER,
    DELETE_LOAD,
}
