package edu.umbc.cmsc447.team10.rest_service.data;

import edu.umbc.cmsc447.team10.rest_service.Util;

import java.io.Serializable;

public abstract class Info implements Serializable {
    @Override
    public String toString() {
        return Util.toStringReflective(this);
    }
}
