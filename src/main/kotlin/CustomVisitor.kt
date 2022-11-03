import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode


class CustomVisitor : arifm_gBaseVisitor<Int?>(), arifm_gVisitor<Int?> {
    val values: MutableMap<String, Int?> = mutableMapOf()
    override fun visitExpr(ctx: arifm_gParser.ExprContext): Int?  {
        val subTreeAll = ctx.children ?: return null
        val subTreeExprs = ctx.expr()
        if (subTreeAll.size == 3)
        {
            if (subTreeAll[0].toString() == "(")
                return visitExpr(subTreeExprs[0])
            val value1 = visitExpr(subTreeExprs[0])
            val value2 = visitExpr(subTreeExprs[1])
            if (value1 == null || value2 == null)
                return null
            return if (subTreeAll[1].toString() == "+")
                value1 + value2
            else
                value1 * value2
        }
        if (ctx.INT() != null)
            return  ctx.INT().toString().toIntOrNull()
        if (ctx.VAR() != null)
            return values[ctx.VAR().toString()]
        return null
    }

    override fun visitVariable(ctx: arifm_gParser.VariableContext): Int? {
        if (ctx.VAR() != null)
            values[ctx.VAR().toString()] = visitExpr(ctx.expr())
        return visitExpr(ctx.expr())
    }

    override fun visitSt(ctx: arifm_gParser.StContext): Int? {
        if (ctx.variable() != null)
            return visitVariable(ctx.variable())
        if (ctx.expr() != null)
            return visitExpr(ctx.expr())
        return null
    }
}