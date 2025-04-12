# LOX LANGUAGE GRAMMAR

```
<program>     = <declaration><program> | EOF

<declaration> = <varDecl> | <statement>
<varDecl>     = var <IDENTIFIER>; | var <IDENTIFIER> = <expression>;
<statement>   = <exprStmt> | <printStmt> | <block> | <ifStmt> | <whileStmt>
<exprStmt>    = <expression>;
<printStmt>   = print <expression>;
<block>       = {<declaration>}
<ifStmt>      = if (<expression>) <statement>
              | if (<expression>) <statement> else <statement>
<whileStmt>   = while (<expression>) <statement>

<expression>  = <assignment>
<assignment>  = <IDENTIFIER> = <assignment> | <equality> | <logicOr>
<logicOr>     = <logicAnd> | <logicAnd> or <logicOr>
<logicAnd>    = <equality> | <equality> and <logicAnd>
<equality>    = <comparison> != <comparison> | <comparison> == <comparison>
<comparison>  = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>        = <factor> - <factor> | <factor> + <factor>
<factor>      = <unary> / <unary> | <unary> * <unary>
<unary>       = !<unary> | -<unary> | <primary>
<primary>     = <NUMBER> | <STRING> | <IDENTIFIER> | true | false | nil | (<expression>)
```