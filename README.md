![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/EGA-SUPREMO/Tanks-game?color=red&label=Version)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
# Tankoj!
A relative-complex tanks game
------
![Screenshot](https://i.ibb.co/6t8rRwM/shor.png)

Everything made from scratch from the graphics engine to the UI ~~BIG mistake btw~~ and designs except the backgrounds.

Similar to [Worms W.M.D.](https://store.steampowered.com/app/327030/Worms_WMD/).

[RPG Game Template](https://github.com/EGA-SUPREMO/RPG-Game-template) made possible this game.

## Gameplay
Tankoj! is a turn-based game where players take turns aiming, adjusting potency, and firing their missile. Each player has a chance to shoot in a round. The game continues in this turn-based fashion until all players have taken their shots. The last tank with remaining health points at the end of the battle is declared the winner. Players can accumulate points during the match to purchase various missiles, force shields, and upgrade their tank's stats (e.g., resistance, speed, HP, gasoline) for the next battle.

[Short Youtube gameplay](https://youtu.be/C3QphZC7b80)

[![](https://i.ibb.co/6t8rRwM/shor.png)](https://youtu.be/C3QphZC7b80)

## Notes
* The code was written with the principle of performace above readability or clarity, e.g. it uses unidimensional arrays for bidimensional arrays, [see here how it's possible](https://github.com/EGA-SUPREMO/Tankoj/blob/master/pixelarray2d.jpg).

* This code is written to have a low tech debt except the UI part, it needs to be replaced to a third party library.

* It almost meets the original requirements and is made to be easy to change (maintainability, extensibility) and easy to understand (readability, formatting, clarity) but lacks of proper documentation.

* This project is currently paused until I decide how to translate this in a web app or made a separate app for mobile and web version and after I find other experienced java developers interested in this project.

* The code as well the commits were written in Esperanto, I will translate them when I have time to invest in this project.

## Known Issues
See [issues section](https://github.com/EGA-SUPREMO/Tanks-game/issues)

## TODOs
* Use a third-party UI library instead of reinventing the wheel.

* Use a bug tracker instead of a text file.

* Add music.

* Add animations, especially the explosions.

* Add sound effects.

* Improve a bit the game's physics.

* Make an usable IU.

* Make proper documentation for make faster to hunt developers.

* Add automated tests.

## License
This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
