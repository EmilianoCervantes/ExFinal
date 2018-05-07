import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		CharStream input = CharStreams.fromStream(System.in); 
		LabeledExprLexer lexer = new LabeledExprLexer(input);
		//LabeledExprLexer lexer = new LabeledExprLexer(CharStreams.fromString("1%2/1%5+2%3"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
        //ParseTreeWalker walker = new ParseTreeWalker();
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
