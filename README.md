Nim plugin for IntelliJ IDEA
============================

This is an IntelliJ IDEA plugin for the Nim programming language. It is
currently under development and is not yet meant for general use.

Testing the plugin
------------------
1. Have IntelliJ IDEA installed along with the **Plugin DevKit** plugin.
2. Clone this repository and open it in IDEA.
3. Mark the _src_ and _gen_ directories as source roots and the _resources_
   directory as a resource root.
4. Create a _Plugin_ run configuration and use it to test the plugin.

Notes
-----
* The contents of the _gen_ directory are generated from the
  [`Nim.bnf`](src/org/dmitrigb/ideanim/Nim.bnf) file using the **Grammar-Kit**
  IntelliJ plugin.
* The [`NimLexer`](src/org/dmitrigb/ideanim/NimLexer.java) class is generated
  from the [`Nim.flex`](src/org/dmitrigb/ideanim/Nim.flex) file using the same
  plugin.