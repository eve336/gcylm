package com.eve.examplemod.api.capability;

public interface IFuelCell {
    int getHeat();
    void changeHeat(int a);
    void subtractHeat(int b);
}
