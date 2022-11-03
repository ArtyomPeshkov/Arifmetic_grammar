// Generated from C:/Users/Artem/IdeaProjects/Arifmetic_grammar/grammar\arifm_g.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link arifm_gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface arifm_gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link arifm_gParser#st}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSt(arifm_gParser.StContext ctx);
	/**
	 * Visit a parse tree produced by {@link arifm_gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(arifm_gParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link arifm_gParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(arifm_gParser.VariableContext ctx);
}