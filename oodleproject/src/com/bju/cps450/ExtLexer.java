package com.bju.cps450;

import com.bju.cps450.lexer.*;
import com.bju.cps450.node.*;
import java.io.*;

/**
 * Created by carragher on 1/18/16.
 */
public class ExtLexer extends Lexer  {


    public ExtLexer(@SuppressWarnings("hiding") PushbackReader in) {
        super(in);
    }

    @Override
    protected void filter() throws LexerException, IOException {
        super.filter();
        if(this.token instanceof TNot){

        }
    }
}
