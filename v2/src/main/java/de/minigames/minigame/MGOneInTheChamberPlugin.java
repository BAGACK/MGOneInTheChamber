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

import java.util.logging.Level;

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
        if (MinigamesLibInterface.instance().getApiVersion() >= MinigamesLibInterface.APIVERSION_2_0_0)
        {
            throw new IllegalStateException("Incompatible MinigamesLib found."); //$NON-NLS-1$
        }
        EnumServiceInterface.instance().registerEnumClass(this, OitcMessages.class);
        EnumServiceInterface.instance().registerEnumClass(this, OitcArenaTypes.class);
        
        try
        {
            MinigamesLibInterface.instance().initMinigame(this, new Minigame());
        }
        catch (McException e)
        {
            this.getLogger().log(Level.SEVERE, "Unable to init OITC", e); //$NON-NLS-1$
            throw new IllegalStateException("Unable to init OITC", e); //$NON-NLS-1$
        }
    }

    @Override
    public void onDisable()
    {
        EnumServiceInterface.instance().unregisterAllEnumerations(this);
    }

}

