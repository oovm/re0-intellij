// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import restart.language.psi_node.*;

public interface RestartTypes {

  IElementType BLOCK = new RestartTokenType("BLOCK");
  IElementType BOOLEAN = new RestartTokenType("BOOLEAN");
  IElementType CALL_SUFFIX = new RestartTokenType("CALL_SUFFIX");
  IElementType DECLARE_BLOCK = new RestartTokenType("DECLARE_BLOCK");
  IElementType DECLARE_ITEM = new RestartTokenType("DECLARE_ITEM");
  IElementType DECLARE_KEY = new RestartTokenType("DECLARE_KEY");
  IElementType DECLARE_STATEMENT = new RestartTokenType("DECLARE_STATEMENT");
  IElementType EF_STATEMENT = new RestartTokenType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new RestartTokenType("ELSE_STATEMENT");
  IElementType EXPRESSION = new RestartTokenType("EXPRESSION");
  IElementType IDENTIFIER = new RestartTokenType("IDENTIFIER");
  IElementType IF_STATEMENT = new RestartTokenType("IF_STATEMENT");
  IElementType KW_DECLARE = new RestartTokenType("KW_DECLARE");
  IElementType MODIFIERS = new RestartTokenType("MODIFIERS");
  IElementType NUMBER = new RestartTokenType("NUMBER");
  IElementType STRING = new RestartTokenType("STRING");

  IElementType BANG = new RestartTokenType("BANG");
  IElementType BRACE_L = new RestartTokenType("{");
  IElementType BRACE_R = new RestartTokenType("}");
  IElementType BRACKET_L = new RestartTokenType("[");
  IElementType BRACKET_R = new RestartTokenType("]");
  IElementType BYTE = new RestartTokenType("Byte");
  IElementType COLON = new RestartTokenType(":");
  IElementType COMMA = new RestartTokenType("COMMA");
  IElementType COMMENT_SL = new RestartTokenType("//");
  IElementType COMMENT_TEXT = new RestartTokenType("Comment");
  IElementType DECIMAL = new RestartTokenType("DECIMAL");
  IElementType DOT = new RestartTokenType(".");
  IElementType INTEGER = new RestartTokenType("INTEGER");
  IElementType KW_ELSE = new RestartTokenType("KW_ELSE");
  IElementType KW_ELSE_IF = new RestartTokenType("KW_ELSE_IF");
  IElementType KW_IF = new RestartTokenType("KW_IF");
  IElementType NUMBER_SUFFIX = new RestartTokenType("NUMBER_SUFFIX");
  IElementType OP_ADD = new RestartTokenType("+");
  IElementType OP_ADD_ASSIGN = new RestartTokenType("+=");
  IElementType OP_AND = new RestartTokenType("&");
  IElementType OP_AND_THEN = new RestartTokenType("and_then");
  IElementType OP_ARROW = new RestartTokenType("->");
  IElementType OP_ARROW2 = new RestartTokenType("=>");
  IElementType OP_AS = new RestartTokenType("OP_AS");
  IElementType OP_BIND = new RestartTokenType(":=");
  IElementType OP_DEC = new RestartTokenType("--");
  IElementType OP_DIV = new RestartTokenType("/");
  IElementType OP_DIV_ASSIGN = new RestartTokenType("/=");
  IElementType OP_EMPTY = new RestartTokenType("(!)");
  IElementType OP_EQ = new RestartTokenType("=");
  IElementType OP_EXISTS = new RestartTokenType("exists");
  IElementType OP_FORALL = new RestartTokenType("forall");
  IElementType OP_GEQ = new RestartTokenType(">=");
  IElementType OP_GG = new RestartTokenType(">>");
  IElementType OP_GGG = new RestartTokenType(">>>");
  IElementType OP_GS = new RestartTokenType("/>");
  IElementType OP_GT = new RestartTokenType(">");
  IElementType OP_IN = new RestartTokenType("in");
  IElementType OP_INC = new RestartTokenType("++");
  IElementType OP_IS_A = new RestartTokenType("is");
  IElementType OP_LEQ = new RestartTokenType("<=");
  IElementType OP_LL = new RestartTokenType("<<");
  IElementType OP_LLL = new RestartTokenType("<<<");
  IElementType OP_LS = new RestartTokenType("</");
  IElementType OP_LT = new RestartTokenType("<");
  IElementType OP_MOD = new RestartTokenType("%");
  IElementType OP_MOD_ASSIGN = new RestartTokenType("%=");
  IElementType OP_MUL = new RestartTokenType("*");
  IElementType OP_MUL_ASSIGN = new RestartTokenType("*=");
  IElementType OP_NE = new RestartTokenType("!=");
  IElementType OP_NOT = new RestartTokenType("!");
  IElementType OP_NOT_A = new RestartTokenType("is not");
  IElementType OP_NOT_IN = new RestartTokenType("not_in");
  IElementType OP_OR = new RestartTokenType("|");
  IElementType OP_OR_ELSE = new RestartTokenType("or_else");
  IElementType OP_POW = new RestartTokenType("^");
  IElementType OP_POW_ASSIGN = new RestartTokenType("OP_POW_ASSIGN");
  IElementType OP_PROPORTION = new RestartTokenType("::");
  IElementType OP_SET = new RestartTokenType("OP_SET");
  IElementType OP_SUB = new RestartTokenType("-");
  IElementType OP_SUB_ASSIGN = new RestartTokenType("-=");
  IElementType PARENTHESIS_L = new RestartTokenType("(");
  IElementType PARENTHESIS_R = new RestartTokenType(")");
  IElementType QUESTION = new RestartTokenType("QUESTION");
  IElementType SEMICOLON = new RestartTokenType(";");
  IElementType SLICE = new RestartTokenType("slice");
  IElementType STRING_END = new RestartTokenType("StringEnd");
  IElementType STRING_START = new RestartTokenType("StringStart");
  IElementType STRING_TEXT = new RestartTokenType("StringText");
  IElementType SYMBOL_RAW = new RestartTokenType("Symbol");
  IElementType SYMBOL_XID = new RestartTokenType("SYMBOL_XID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK) {
        return new RestartBlockNode(node);
      }
      else if (type == BOOLEAN) {
        return new RestartBooleanNode(node);
      }
      else if (type == CALL_SUFFIX) {
        return new RestartCallSuffixNode(node);
      }
      else if (type == DECLARE_BLOCK) {
        return new RestartDeclareBlockNode(node);
      }
      else if (type == DECLARE_ITEM) {
        return new RestartDeclareItemNode(node);
      }
      else if (type == DECLARE_KEY) {
        return new RestartDeclareKeyNode(node);
      }
      else if (type == DECLARE_STATEMENT) {
        return new RestartDeclareStatementNode(node);
      }
      else if (type == EF_STATEMENT) {
        return new RestartEfStatementNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new RestartElseStatementNode(node);
      }
      else if (type == EXPRESSION) {
        return new RestartExpressionNode(node);
      }
      else if (type == IDENTIFIER) {
        return new RestartIdentifierNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new RestartIfStatementNode(node);
      }
      else if (type == KW_DECLARE) {
        return new RestartKwDeclareNode(node);
      }
      else if (type == MODIFIERS) {
        return new RestartModifiersNode(node);
      }
      else if (type == NUMBER) {
        return new RestartNumberNode(node);
      }
      else if (type == STRING) {
        return new RestartStringNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
