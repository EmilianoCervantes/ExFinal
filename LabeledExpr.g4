grammar LabeledExpr;
 
prog: stat+;
 
stat:   expr NEWLINE            # printExpr
    |   ID '=' expr NEWLINE     # assign
    |   NEWLINE                 # blank
    ;
     
expr:   expr op=('*'|'/') expr  # MulDiv
    |   expr op=('+'|'-') expr  # AddSub
    |   FRAC                    # Fracction
    |   '(' expr ')'            # parens
    ;
     
MUL:    '*';
DIV:    '/';
ADD:    '+';
SUB:    '-';

NEWLINE:    '\r'? '\n';
ID:         [a-zA-Z]+;
INT:        [0-9]+;
FRAC		: INT'%'[1-9][0-9]*;
/*WS:         [ \t]+ -> skip;*/