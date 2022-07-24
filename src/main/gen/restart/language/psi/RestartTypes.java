// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import restart.language.psi_node.*;

public interface RestartTypes {

  IElementType AWARD_STATEMENT = new RestartTokenType("AWARD_STATEMENT");
  IElementType BLOCK = new RestartTokenType("BLOCK");
  IElementType BOOLEAN = new RestartTokenType("BOOLEAN");
  IElementType BRACE_BLOCK = new RestartTokenType("BRACE_BLOCK");
  IElementType BRACKET_FREE = new RestartTokenType("BRACKET_FREE");
  IElementType CALL_SUFFIX = new RestartTokenType("CALL_SUFFIX");
  IElementType CASE_PATTERN = new RestartTokenType("CASE_PATTERN");
  IElementType CONDITION = new RestartTokenType("CONDITION");
  IElementType DECLARE_BLOCK = new RestartTokenType("DECLARE_BLOCK");
  IElementType DECLARE_ITEM = new RestartTokenType("DECLARE_ITEM");
  IElementType DECLARE_KEY = new RestartTokenType("DECLARE_KEY");
  IElementType DECLARE_STATEMENT = new RestartTokenType("DECLARE_STATEMENT");
  IElementType EF_STATEMENT = new RestartTokenType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new RestartTokenType("ELSE_STATEMENT");
  IElementType EVENT_STATEMENT = new RestartTokenType("EVENT_STATEMENT");
  IElementType EXPRESSION = new RestartTokenType("EXPRESSION");
  IElementType FOR_STATEMENT = new RestartTokenType("FOR_STATEMENT");
  IElementType HERO_STATEMENT = new RestartTokenType("HERO_STATEMENT");
  IElementType IDENTIFIER = new RestartTokenType("IDENTIFIER");
  IElementType IF_GUARD = new RestartTokenType("IF_GUARD");
  IElementType IF_STATEMENT = new RestartTokenType("IF_STATEMENT");
  IElementType KW_AWARD = new RestartTokenType("KW_AWARD");
  IElementType KW_DECLARE = new RestartTokenType("KW_DECLARE");
  IElementType KW_EVENT = new RestartTokenType("KW_EVENT");
  IElementType KW_HERO = new RestartTokenType("KW_HERO");
  IElementType KW_TALENT = new RestartTokenType("KW_TALENT");
  IElementType KW_VARIABLE = new RestartTokenType("KW_VARIABLE");
  IElementType LIST = new RestartTokenType("LIST");
  IElementType MODIFIERS = new RestartTokenType("MODIFIERS");
  IElementType NAMEPATH = new RestartTokenType("NAMEPATH");
  IElementType NORMAL_PATTERN = new RestartTokenType("NORMAL_PATTERN");
  IElementType NUMBER = new RestartTokenType("NUMBER");
  IElementType PATTERN_ITEM = new RestartTokenType("PATTERN_ITEM");
  IElementType RANGE = new RestartTokenType("RANGE");
  IElementType SLICE = new RestartTokenType("SLICE");
  IElementType SLICE_ITEM = new RestartTokenType("SLICE_ITEM");
  IElementType STRING = new RestartTokenType("STRING");
  IElementType TALENT_STATEMENT = new RestartTokenType("TALENT_STATEMENT");
  IElementType TUPLE = new RestartTokenType("TUPLE");
  IElementType VARIABLE_STATEMENT = new RestartTokenType("VARIABLE_STATEMENT");
  IElementType WHILE_STATEMENT = new RestartTokenType("WHILE_STATEMENT");

  IElementType AMP = new RestartTokenType("AMP");
  IElementType BANG = new RestartTokenType("BANG");
  IElementType BRACE_L = new RestartTokenType("{");
  IElementType BRACE_R = new RestartTokenType("}");
  IElementType BRACKET_L = new RestartTokenType("[");
  IElementType BRACKET_R = new RestartTokenType("]");
  IElementType BYTE = new RestartTokenType("Byte");
  IElementType CASE = new RestartTokenType("CASE");
  IElementType COLON = new RestartTokenType(":");
  IElementType COMMA = new RestartTokenType("COMMA");
  IElementType COMMENT_SL = new RestartTokenType("//");
  IElementType COMMENT_TEXT = new RestartTokenType("Comment");
  IElementType DECIMAL = new RestartTokenType("DECIMAL");
  IElementType DOT = new RestartTokenType(".");
  IElementType DOT2 = new RestartTokenType("DOT2");
  IElementType DOT3 = new RestartTokenType("DOT3");
  IElementType DOT_EQ = new RestartTokenType("DOT_EQ");
  IElementType DOT_LESS = new RestartTokenType("DOT_LESS");
  IElementType INTEGER = new RestartTokenType("INTEGER");
  IElementType KW_ELSE = new RestartTokenType("KW_ELSE");
  IElementType KW_ELSE_IF = new RestartTokenType("KW_ELSE_IF");
  IElementType KW_FOR = new RestartTokenType("KW_FOR");
  IElementType KW_IF = new RestartTokenType("KW_IF");
  IElementType NUMBER_SUFFIX = new RestartTokenType("NUMBER_SUFFIX");
  IElementType OP_ADD = new RestartTokenType("+");
  IElementType OP_ADD_ASSIGN = new RestartTokenType("+=");
  IElementType OP_AND = new RestartTokenType("&");
  IElementType OP_AND2 = new RestartTokenType("&&");
  IElementType OP_AND_ASSIGN = new RestartTokenType("&=");
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
  IElementType OP_NAMESAPCE = new RestartTokenType("namespace");
  IElementType OP_NE = new RestartTokenType("!=");
  IElementType OP_NOT = new RestartTokenType("!");
  IElementType OP_NOT_A = new RestartTokenType("is not");
  IElementType OP_NOT_IN = new RestartTokenType("not_in");
  IElementType OP_OR = new RestartTokenType("|");
  IElementType OP_OR2 = new RestartTokenType("||");
  IElementType OP_OR_ASSIGN = new RestartTokenType("|=");
  IElementType OP_OR_ELSE = new RestartTokenType("or_else");
  IElementType OP_POW = new RestartTokenType("^");
  IElementType OP_POW_ASSIGN = new RestartTokenType("OP_POW_ASSIGN");
  IElementType OP_PROPORTION = new RestartTokenType("::");
  IElementType OP_SET = new RestartTokenType("OP_SET");
  IElementType OP_SUB = new RestartTokenType("-");
  IElementType OP_SUB_ASSIGN = new RestartTokenType("-=");
  IElementType OP_TO = new RestartTokenType("OP_TO");
  IElementType PARENTHESIS_L = new RestartTokenType("(");
  IElementType PARENTHESIS_R = new RestartTokenType(")");
  IElementType QUESTION = new RestartTokenType("QUESTION");
  IElementType SEMICOLON = new RestartTokenType(";");
  IElementType SLICE_L = new RestartTokenType("[[");
  IElementType SLICE_R = new RestartTokenType("]]");
  IElementType STRING_END = new RestartTokenType("StringEnd");
  IElementType STRING_START = new RestartTokenType("StringStart");
  IElementType STRING_TEXT = new RestartTokenType("StringText");
  IElementType SYMBOL_RAW = new RestartTokenType("Symbol");
  IElementType SYMBOL_XID = new RestartTokenType("SYMBOL_XID");
  IElementType WHILE = new RestartTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AWARD_STATEMENT) {
        return new RestartAwardStatementNode(node);
      }
      else if (type == BLOCK) {
        return new RestartBlockNode(node);
      }
      else if (type == BOOLEAN) {
        return new RestartBooleanNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new RestartBraceBlockNode(node);
      }
      else if (type == BRACKET_FREE) {
        return new RestartBracketFreeNode(node);
      }
      else if (type == CALL_SUFFIX) {
        return new RestartCallSuffixNode(node);
      }
      else if (type == CASE_PATTERN) {
        return new RestartCasePatternNode(node);
      }
      else if (type == CONDITION) {
        return new RestartConditionNode(node);
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
      else if (type == EVENT_STATEMENT) {
        return new RestartEventStatementNode(node);
      }
      else if (type == EXPRESSION) {
        return new RestartExpressionNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new RestartForStatementNode(node);
      }
      else if (type == HERO_STATEMENT) {
        return new RestartHeroStatementNode(node);
      }
      else if (type == IDENTIFIER) {
        return new RestartIdentifierNode(node);
      }
      else if (type == IF_GUARD) {
        return new RestartIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new RestartIfStatementNode(node);
      }
      else if (type == KW_AWARD) {
        return new RestartKwAwardNode(node);
      }
      else if (type == KW_DECLARE) {
        return new RestartKwDeclareNode(node);
      }
      else if (type == KW_EVENT) {
        return new RestartKwEventNode(node);
      }
      else if (type == KW_HERO) {
        return new RestartKwHeroNode(node);
      }
      else if (type == KW_TALENT) {
        return new RestartKwTalentNode(node);
      }
      else if (type == KW_VARIABLE) {
        return new RestartKwVariableNode(node);
      }
      else if (type == LIST) {
        return new RestartListNode(node);
      }
      else if (type == MODIFIERS) {
        return new RestartModifiersNode(node);
      }
      else if (type == NAMEPATH) {
        return new RestartNamepathNode(node);
      }
      else if (type == NORMAL_PATTERN) {
        return new RestartNormalPatternNode(node);
      }
      else if (type == NUMBER) {
        return new RestartNumberNode(node);
      }
      else if (type == PATTERN_ITEM) {
        return new RestartPatternItemNode(node);
      }
      else if (type == RANGE) {
        return new RestartRangeNode(node);
      }
      else if (type == SLICE) {
        return new RestartSliceNode(node);
      }
      else if (type == SLICE_ITEM) {
        return new RestartSliceItemNode(node);
      }
      else if (type == STRING) {
        return new RestartStringNode(node);
      }
      else if (type == TALENT_STATEMENT) {
        return new RestartTalentStatementNode(node);
      }
      else if (type == TUPLE) {
        return new RestartTupleNode(node);
      }
      else if (type == VARIABLE_STATEMENT) {
        return new RestartVariableStatementNode(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new RestartWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
