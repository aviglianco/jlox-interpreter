# LOX LANGUAGE GRAMMAR

```
<program>     = <declaration><program> | EOF

<declaration> = <classDecl> | <funDecl> | <varDecl> | <statement>
<classDecl>   = class <IDENTIFIER> { <function> }
              | class <IDENTIFIER> < <IDENTIFIER> { <function> }
<funDecl>     = fun <function>
<function>    = <IDENTIFIER> (<parameters>) <block>
<varDecl>     = var <IDENTIFIER>; | var <IDENTIFIER> = <expression>;
<statement>   = <exprStmt> | <printStmt> | <block> | <forStmt> 
              | <ifStmt> | <whileStmt> | <breakStmt> | <returnStmt>
<exprStmt>    = <expression>;
<printStmt>   = print <expression>;
<forStmt>     = for (<varDecl>; <expression>; <expression>) <statement>
<block>       = {<declaration>}
<ifStmt>      = if (<expression>) <statement>
              | if (<expression>) <statement> else <statement>
<whileStmt>   = while (<expression>) <statement>
<breakStmt>   = break;  // Only allowed inside loops
<returnStmt>  = return <expression>; | return;

<expression>  = <assignment>
<assignment>  = <IDENTIFIER> = <assignment> | <equality> | <logicOr>
<logicOr>     = <logicAnd> | <logicAnd> or <logicOr>
<logicAnd>    = <equality> | <equality> and <logicAnd>
<equality>    = <comparison> != <comparison> | <comparison> == <comparison>
<comparison>  = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>        = <factor> - <factor> | <factor> + <factor>
<factor>      = <unary> / <unary> | <unary> * <unary>
<unary>       = !<unary> | -<unary> | <call>
<call>        = <primary>() | <primary>(<arguments>)
<arguments>   = <expression> | <expression>, <arguments>
<primary>     = <NUMBER> | <STRING> | <IDENTIFIER> | true | false | nil | (<expression>)
```