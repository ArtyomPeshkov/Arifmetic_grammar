grammar arifm_g;
st: variable ';' | expr ';';
expr: expr '+' expr | expr '*' expr | '('expr')' | VAR | INT ;
variable: VAR'='expr;

INT: ('0'..'9')+;
VAR: ( '_' |'a'..'z' | 'A'..'Z')+ ( '_' | 'a'..'z' | 'A'..'Z' | '0'..'9')*;
WS  : [ \t\n]+ -> skip;