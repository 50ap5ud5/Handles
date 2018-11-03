package com.vandendaelen.handles.object.tileentity;

import com.vandendaelen.handles.utils.IHandlesPeripheral;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.tardis.mod.common.tileentity.TileEntityTardis;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileTardisInterfaceCC extends TileTardisInterfaceBase implements IHandlesPeripheral {

    @Nonnull
    @Override
    public String getType() {
        return peripheralName;
    }

    @Nonnull
    @Override
    public String[] getMethodNames() {
        return METHODS.toArray(new String[0]);
    }

    @Nullable
    @Override
    public Object[] callMethod(@Nonnull IComputerAccess computer, @Nonnull ILuaContext context, int method, @Nonnull Object[] arguments) throws LuaException, InterruptedException {
        TileEntityTardis te = getTardis();
        switch (method){
            case 0:{
                return getTardisPos(te);
            }
            case 1:{
                if (arguments.length < 4)
                    throw new LuaException("Not enough argument : setTardisPos(x,y,z,dimensionID)");
                if (arguments.length > 4)
                    throw new LuaException("Too many arguments : setTardisPos(x,y,z,dimensionID)");
                return setTardisPos(arguments,te);
            }
            case 2:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : startFlight()");
                return startFlight(te);
            }
            case 3:{
                if (arguments.length < 1)
                    throw new LuaException("Not enough argument : setDoors(boolean)");
                if (arguments.length > 1)
                    throw new LuaException("Too many arguments : setDoors(boolean)");
                return setDoors(arguments,te);
            }
            case 4:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : isInFlight()");
                return isInFlight(te);
            }
            case 5:{
                if (arguments.length < 1)
                    throw new LuaException("Not enough argument : setFueling(boolean)");
                if (arguments.length > 1)
                    throw new LuaException("Too many arguments : setFueling(boolean)");
                return setFueling(arguments,te);
            }
            case 6:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : getFuel()");
                return getFuel(te);
            }
            case 7:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : isDoorsOpenned()");
                return isDoorsOpenned(te);
            }
            case 8:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : canFly()");
                return canFly(te);
            }
            case 9:{
                if (arguments.length >= 1)
                    throw new LuaException("Too many arguments : getTravelTime()");
                return getTravelTime(te);
            }
            default:{
                return new Object[0];
            }
        }
    }

    @Override
    public boolean equals(@Nullable IPeripheral other){
        return super.equals(other);
    }
}