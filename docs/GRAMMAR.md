# LOX LANGUAGE ABSTRACT GRAMMAR

We will start with a first approach that includes only a subset of the language.

The abstract grammar for the Lox language is given by the following productions:

```
<expression> = <literal> | <unary> | <binary> | <grouping>
<literal>    = <NUMBER> | <STRING> | true | false | nil
<grouping>   = (<expression>)
<unary>      = !<expression> | -<expression>
<binary>     = <expression> <operator> <expression>
<operator>   = == | != | < | <= | > | >= | + | - | * | /
```

For the parsing step, we consider a disambiguated grammar given by the following productions:

```
<expression> = <equality>
<equality>   = <comparison> != <comparison> | <comparison> == <comparison>
<comparison> = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>       = <factor> - <factor> | <factor> + <factor>
<factor>     = <unary> / <unary> | <unary> * <unary>
<unary>      = !<unary> | -<unary> | <primary>
<primary>    = <NUMBER> | <STRING> | true | false | nil | (<expression>)
```

To extend the power of our languages and include statements, we have to extend our grammar
to the following:

```
<program>    = <statement><program> | EOF
<statement>  = <exprStmt> | <printStmt>
<exprStmt>   = <expression>;
<printStmt>  = print <expression>;

<expression> = <equality>
<equality>   = <comparison> != <comparison> | <comparison> == <comparison>
<comparison> = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>       = <factor> - <factor> | <factor> + <factor>
<factor>     = <unary> / <unary> | <unary> * <unary>
<unary>      = !<unary> | -<unary> | <primary>
<primary>    = <NUMBER> | <STRING> | true | false | nil | (<expression>)
```

Now we want to support the declaration and use of variables, so we have to extend our grammar
with the following productions:

```
<program>     = <declaration><program> | EOF

<declaration> = <varDecl> | <statement>
<varDecl>     = var <IDENTIFIER>; | var <IDENTIFIER> = <expression>;
<statement>   = <exprStmt> | <printStmt>
<exprStmt>    = <expression>;
<printStmt>   = print <expression>;

<expression>  = <assignment>
<assignment>  = <IDENTIFIER> = <assignment> | <equality>
<equality>    = <comparison> != <comparison> | <comparison> == <comparison>
<comparison>  = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>        = <factor> - <factor> | <factor> + <factor>
<factor>      = <unary> / <unary> | <unary> * <unary>
<unary>       = !<unary> | -<unary> | <primary>
<primary>     = <NUMBER> | <STRING> | <IDENTIFIER> | true | false | nil | (<expression>)
```

If we add blocks to our language, the grammar has to be extended to the following:

```
<program>     = <declaration><program> | EOF

<declaration> = <varDecl> | <statement>
<varDecl>     = var <IDENTIFIER>; | var <IDENTIFIER> = <expression>;
<statement>   = <exprStmt> | <printStmt> | <block>
<exprStmt>    = <expression>;
<printStmt>   = print <expression>;
<block>       = {<declaration>}

<expression>  = <assignment>
<assignment>  = <IDENTIFIER> = <assignment> | <equality>
<equality>    = <comparison> != <comparison> | <comparison> == <comparison>
<comparison>  = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>        = <factor> - <factor> | <factor> + <factor>
<factor>      = <unary> / <unary> | <unary> * <unary>
<unary>       = !<unary> | -<unary> | <primary>
<primary>     = <NUMBER> | <STRING> | <IDENTIFIER> | true | false | nil | (<expression>)
```

When adding control flow to our language, we have to extend the grammar even further:

```
<program>     = <declaration><program> | EOF

<declaration> = <varDecl> | <statement>
<varDecl>     = var <IDENTIFIER>; | var <IDENTIFIER> = <expression>;
<statement>   = <exprStmt> | <printStmt> | <block> | <ifStmt>
<exprStmt>    = <expression>;
<printStmt>   = print <expression>;
<block>       = {<declaration>}
<ifStmt>      = if (<expression>) <statement>
              | if (<expression>) <statement> else <statement>

<expression>  = <assignment>
<assignment>  = <IDENTIFIER> = <assignment> | <equality>
<equality>    = <comparison> != <comparison> | <comparison> == <comparison>
<comparison>  = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>        = <factor> - <factor> | <factor> + <factor>
<factor>      = <unary> / <unary> | <unary> * <unary>
<unary>       = !<unary> | -<unary> | <primary>
<primary>     = <NUMBER> | <STRING> | <IDENTIFIER> | true | false | nil | (<expression>)
```