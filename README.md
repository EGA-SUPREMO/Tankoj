# Tankoj!

This is a tank game, similar to the famous game "Worms", the first player aim, set the potency and fire! then next one and the next one until every player has shot begin the next turn, the last tank with health points win the battle and can use the points it earned to buy different missiles, force shields and upgrade its stats like resistance, speed, HP, gasoline, etc, to next battle.


[![](https://i.ibb.co/6t8rRwM/shor.png)](https://youtu.be/C3QphZC7b80)

Here is a short gameplay.

## Notes

* This code is written to have a low tech debt except the UI part, it needs to be replaced to a third party library.

* It almost meets the original requirements and is made to be easy to change (maintainability, extensibility) and easy to understand (readability, formatting, clarity) but lacks of proper documentation.

* This project is currently paused until I decide how to translate this in a web app or made a separate app for mobile and web version and after I find other experienced java developers interested in this project.

* The code as well the commits were written in Esperanto, I will translate them when I have time to invest in this project.

## Know Issues

* There's a bug where sometimes the missile's angle starts at a negative number, provably should be added a checker before the missile is launched to fix that.

* Because a few threads load the background simultaneously while the game request that images that still haven't been loaded generating the typical null pointer exception.

* The missile's angle set to 0 when passes the map's coordinate X: 0.

## TODO

* Use a third-party UI library instead of reinventing the wheel.

* Use a bug tracker instead of a text file.

* Add music.

* Add sound effects.

* Improve a bit the game's physics.

* Make and usable IU.

* Make proper documentation for make faster to hunt developers.

## Lincense

This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
