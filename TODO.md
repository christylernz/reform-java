Reform TODO
===========

Far future concepts:
--------------------
- Accessibility

Conceptually open:
------------------
- Iterate over points
- Form Groups
- Snap point filter: option to show only snap points of selected form
- Path Tool
- Array-Values in Expressions
- Export animation (eg gif)
- Export JavaScript (eg d3)
- Export bytecode
- Zoom
- Rectangle Width/Height scale
- Masking (Instruction scopes?)
- Layers, Boolean Combination
- List of errors
- Magnets
- Rulers

Minor improvements:
-------------------
- color constants: red, green, blue, cyan, yellow, megenta...
- expression table column sorting
- Duplicating Definitions
- Duplicating Pictures

Open:
-----
- Tool State description (anymore???)
- changeable Form names
- Glomp Points
- Undo/Redo
- Manual No-Snap mode
- merge consecutive instructions if possible
- improve scrolling when resizing canvas
- Increment/Decrement Expressions
- Iteration Focus
- Multiple Instruction Selection
- Improve Error-Checking in analyzer and runtime regarding expressions
- Add Expression-Distance
- Add Expression-Destination

UI open:
--------
- icons for instructions
- mark instructions affecting or depending on selected form
- folding group instructions
- label instructions

In Progress:
------------
- Recursion
 - simplify recursion runtime listener
 - refresh outer picture if embedded picture changes
- later instruction changes
- Data Grid / Measurements
- Fix loop-nesting-protection
- Adjust serializer to support latest changes

Bugs:
-----
- fix degenerated arc rotation
- keep selection when canceling tool (focus get's reset)
- sort shapes correctly

Done:
-----
- Text Shape
- Export SVG
- Shunting Yard
- Cycle resolving
- color picker Hue slider singularity


Not important:
--------------
- Rewrite tokenizer
- simplify arc calculation
