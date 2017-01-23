/*
    Copyright 2016 by minigameslib.de
    All rights reserved.
    If you do not own a hand-signed commercial license from minigames.de
    you are not allowed to use this software in any way except using
    GPL (see below).

------

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/

package de.minigames.minigame;

import org.bukkit.plugin.java.JavaPlugin;

import de.minigameslib.mclib.api.McException;
import de.minigameslib.mclib.api.enums.EnumServiceInterface;
import de.minigameslib.mgapi.api.MinigamesLibInterface;

/**
 * One-In-The-Chamber main plugin class
 * 
 * @author mepeisen
 */
public class MGOneInTheChamberPlugin extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        // TODO check api version
        EnumServiceInterface.instance().registerEnumClass(this, OitcMessages.class);
        EnumServiceInterface.instance().registerEnumClass(this, OitcArenaTypes.class);
        
        try
        {
            MinigamesLibInterface.instance().initMinigame(this, new Minigame());
        }
        catch (McException e)
        {
            // TODO Logging
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable()
    {
        EnumServiceInterface.instance().unregisterAllEnumerations(this);
    }

}

