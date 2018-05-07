import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
 
public class EvalVisitor extends LabeledExprBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<String, Double>();
    Stack<Fraccion> pila = new Stack<Fraccion>();
     
    @Override
    public Double visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        double value = visit(ctx.expr());
        memory.put(id, value);
        
        Fraccion f = pila.pop();
		System.out.println("resultado " + f);
        
        return value;
    }
     
    @Override
    public Double visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        System.out.println(value);
        return 0.;
    }
     
    /*@Override
    public Double visitInt(LabeledExprParser.IntContext ctx) {
        return Double.valueOf(ctx.INT().getText());
    }*/
    
    
    @Override
	public Double visitFracction(LabeledExprParser.FracctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFracction(ctx);
	}
     
    @Override
    public Double visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == LabeledExprParser.MUL ) return left * right;
        return left / right;
    }
 
    @Override
    public Double visitAddSub(LabeledExprParser.AddSubContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == LabeledExprParser.ADD ) return left + right;
        return left - right;
    }
     
    @Override
    public Double visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
