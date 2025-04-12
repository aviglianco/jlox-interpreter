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
<program> = <statement><program> | EOF
<statement> = <exprStmt> | <printStmt>
<exprStmt> = <expression>;
<printStmt> = print <expression>;

<expression> = <equality>
<equality>   = <comparison> != <comparison> | <comparison> == <comparison>
<comparison> = <term> > <term> | <term> >= <term> | <term> < <term> | <term> <= <term>
<term>       = <factor> - <factor> | <factor> + <factor>
<factor>     = <unary> / <unary> | <unary> * <unary>
<unary>      = !<unary> | -<unary> | <primary>
<primary>    = <NUMBER> | <STRING> | true | false | nil | (<expression>)
```
