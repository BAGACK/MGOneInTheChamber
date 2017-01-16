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

import de.minigameslib.mclib.api.enums.ChildEnum;
import de.minigameslib.mclib.api.locale.LocalizedMessage;
import de.minigameslib.mclib.api.locale.LocalizedMessageInterface;
import de.minigameslib.mclib.api.locale.LocalizedMessages;
import de.minigameslib.mclib.api.locale.MessageComment;

/**
 * Localized messages for OneInTheChamber
 * 
 * @author mepeisen
 */
@LocalizedMessages("core")
@ChildEnum({
    OitcStandardArena.Messages.class,
    OitcTeamsArena.Messages.class
})
public enum OitcMessages implements LocalizedMessageInterface
{
    
    /**
     * The display name
     */
    @LocalizedMessage(defaultMessage = LocalizedMessage.GOLD + "One" + LocalizedMessage.DARK_RED + "In" + LocalizedMessage.GOLD + "The" + LocalizedMessage.DARK_RED + "Chamber")
    @MessageComment("the display name")
    DisplayName,
    
    /**
     * Short description
     */
    @LocalizedMessage(defaultMessage = "PvP arena with instant-kill bow")
    @MessageComment("Short description")
    ShortDescription,
    
    /**
     * Long description
     */
    @LocalizedMessage(defaultMessage = "PvP arena with instant-kill bow") // TODO some nice text
    @MessageComment("Long description")
    Description,
    
    /**
     * how-to-play manual
     */
    @LocalizedMessage(defaultMessage = "PvP arena with instant-kill bow") // TODO some nice text
    @MessageComment("A how-to-play manual")
    Manual,
    
}
