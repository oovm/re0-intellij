// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType AWARD_STATEMENT = new ValkyrieTokenType("AWARD_STATEMENT");
  IElementType BOOLEAN = new ValkyrieTokenType("BOOLEAN");
  IElementType BRACE_BLOCK = new ValkyrieTokenType("BRACE_BLOCK");
  IElementType CALL_SUFFIX = new ValkyrieTokenType("CALL_SUFFIX");
  IElementType CASE_PATTERN = new ValkyrieTokenType("CASE_PATTERN");
  IElementType CONDITION = new ValkyrieTokenType("CONDITION");
  IElementType DECLARE_STATEMENT = new ValkyrieTokenType("DECLARE_STATEMENT");
  IElementType EF_STATEMENT = new ValkyrieTokenType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieTokenType("ELSE_STATEMENT");
  IElementType EVENT_STATEMENT = new ValkyrieTokenType("EVENT_STATEMENT");
  IElementType EXPRESSION = new ValkyrieTokenType("EXPRESSION");
  IElementType FOR_STATEMENT = new ValkyrieTokenType("FOR_STATEMENT");
  IElementType HERO_STATEMENT = new ValkyrieTokenType("HERO_STATEMENT");
  IElementType IDENTIFIER = new ValkyrieTokenType("IDENTIFIER");
  IElementType IF_GUARD = new ValkyrieTokenType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieTokenType("IF_STATEMENT");
  IElementType KW_AWARD = new ValkyrieTokenType("KW_AWARD");
  IElementType KW_DECLARE = new ValkyrieTokenType("KW_DECLARE");
  IElementType KW_ELSE_IF = new ValkyrieTokenType("KW_ELSE_IF");
  IElementType KW_EVENT = new ValkyrieTokenType("KW_EVENT");
  IElementType KW_HERO = new ValkyrieTokenType("KW_HERO");
  IElementType KW_VARIABLE = new ValkyrieTokenType("KW_VARIABLE");
  IElementType LIST = new ValkyrieTokenType("LIST");
  IElementType MODIFIERS = new ValkyrieTokenType("MODIFIERS");
  IElementType NAMEPATH = new ValkyrieTokenType("NAMEPATH");
  IElementType NEW_STATEMENT = new ValkyrieTokenType("NEW_STATEMENT");
  IElementType NORMAL_PATTERN = new ValkyrieTokenType("NORMAL_PATTERN");
  IElementType NUMBER = new ValkyrieTokenType("NUMBER");
  IElementType PATTERN_ITEM = new ValkyrieTokenType("PATTERN_ITEM");
  IElementType PATTERN_PAIR = new ValkyrieTokenType("PATTERN_PAIR");
  IElementType PATTERN_VALUE = new ValkyrieTokenType("PATTERN_VALUE");
  IElementType RANGE = new ValkyrieTokenType("RANGE");
  IElementType SLICE = new ValkyrieTokenType("SLICE");
  IElementType SLICE_ITEM = new ValkyrieTokenType("SLICE_ITEM");
  IElementType STRING = new ValkyrieTokenType("STRING");
  IElementType TRAIT_BLOCK = new ValkyrieTokenType("TRAIT_BLOCK");
  IElementType TUPLE = new ValkyrieTokenType("TUPLE");
  IElementType TYPE_EXPRESSION = new ValkyrieTokenType("TYPE_EXPRESSION");
  IElementType TYPE_GENERIC = new ValkyrieTokenType("TYPE_GENERIC");
  IElementType VARIABLE_STATEMENT = new ValkyrieTokenType("VARIABLE_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieTokenType("WHILE_STATEMENT");

  IElementType AMP = new ValkyrieTokenType("AMP");
  IElementType BANG = new ValkyrieTokenType("BANG");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
  IElementType CASE = new ValkyrieTokenType("CASE");
  IElementType COLON = new ValkyrieTokenType(":");
  IElementType COMMA = new ValkyrieTokenType("COMMA");
  IElementType COMMENT = new ValkyrieTokenType("Comment");
  IElementType DECIMAL = new ValkyrieTokenType("DECIMAL");
  IElementType DOT = new ValkyrieTokenType(".");
  IElementType DOT2 = new ValkyrieTokenType("DOT2");
  IElementType DOT3 = new ValkyrieTokenType("DOT3");
  IElementType DOT_EQ = new ValkyrieTokenType("DOT_EQ");
  IElementType DOT_LESS = new ValkyrieTokenType("DOT_LESS");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType KW_FOR = new ValkyrieTokenType("KW_FOR");
  IElementType KW_IF = new ValkyrieTokenType("KW_IF");
  IElementType NEW = new ValkyrieTokenType("NEW");
  IElementType OP_ADD = new ValkyrieTokenType("+");
  IElementType OP_ADD_ASSIGN = new ValkyrieTokenType("+=");
  IElementType OP_AND = new ValkyrieTokenType("&");
  IElementType OP_AND2 = new ValkyrieTokenType("&&");
  IElementType OP_AND_ASSIGN = new ValkyrieTokenType("&=");
  IElementType OP_AND_THEN = new ValkyrieTokenType("and_then");
  IElementType OP_ARROW = new ValkyrieTokenType("->");
  IElementType OP_ARROW2 = new ValkyrieTokenType("=>");
  IElementType OP_AS = new ValkyrieTokenType("OP_AS");
  IElementType OP_BIND = new ValkyrieTokenType(":=");
  IElementType OP_DEC = new ValkyrieTokenType("--");
  IElementType OP_DIV = new ValkyrieTokenType("/");
  IElementType OP_DIV_ASSIGN = new ValkyrieTokenType("/=");
  IElementType OP_EMPTY = new ValkyrieTokenType("(!)");
  IElementType OP_EQ = new ValkyrieTokenType("=");
  IElementType OP_EXISTS = new ValkyrieTokenType("exists");
  IElementType OP_FORALL = new ValkyrieTokenType("forall");
  IElementType OP_GEQ = new ValkyrieTokenType(">=");
  IElementType OP_GG = new ValkyrieTokenType(">>");
  IElementType OP_GGG = new ValkyrieTokenType(">>>");
  IElementType OP_GS = new ValkyrieTokenType("/>");
  IElementType OP_GT = new ValkyrieTokenType(">");
  IElementType OP_IN = new ValkyrieTokenType("in");
  IElementType OP_INC = new ValkyrieTokenType("++");
  IElementType OP_IS_A = new ValkyrieTokenType("is");
  IElementType OP_LEQ = new ValkyrieTokenType("<=");
  IElementType OP_LL = new ValkyrieTokenType("<<");
  IElementType OP_LLL = new ValkyrieTokenType("<<<");
  IElementType OP_LS = new ValkyrieTokenType("</");
  IElementType OP_LT = new ValkyrieTokenType("<");
  IElementType OP_MOD = new ValkyrieTokenType("%");
  IElementType OP_MOD_ASSIGN = new ValkyrieTokenType("%=");
  IElementType OP_MUL = new ValkyrieTokenType("*");
  IElementType OP_MUL_ASSIGN = new ValkyrieTokenType("*=");
  IElementType OP_NAMESAPCE = new ValkyrieTokenType("namespace");
  IElementType OP_NE = new ValkyrieTokenType("!=");
  IElementType OP_NOT = new ValkyrieTokenType("!");
  IElementType OP_NOT_A = new ValkyrieTokenType("is not");
  IElementType OP_NOT_IN = new ValkyrieTokenType("not_in");
  IElementType OP_OR = new ValkyrieTokenType("|");
  IElementType OP_OR2 = new ValkyrieTokenType("||");
  IElementType OP_OR_ASSIGN = new ValkyrieTokenType("|=");
  IElementType OP_OR_ELSE = new ValkyrieTokenType("or_else");
  IElementType OP_POW = new ValkyrieTokenType("^");
  IElementType OP_POW_ASSIGN = new ValkyrieTokenType("OP_POW_ASSIGN");
  IElementType OP_PROPORTION = new ValkyrieTokenType("::");
  IElementType OP_SET = new ValkyrieTokenType("OP_SET");
  IElementType OP_SUB = new ValkyrieTokenType("-");
  IElementType OP_SUB_ASSIGN = new ValkyrieTokenType("-=");
  IElementType OP_TO = new ValkyrieTokenType("OP_TO");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType QUESTION = new ValkyrieTokenType("QUESTION");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType SLICE_L = new ValkyrieTokenType("[[");
  IElementType SLICE_R = new ValkyrieTokenType("]]");
  IElementType STRING_END = new ValkyrieTokenType("StringEnd");
  IElementType STRING_START = new ValkyrieTokenType("StringStart");
  IElementType STRING_TEXT = new ValkyrieTokenType("StringText");
  IElementType SYMBOL_RAW = new ValkyrieTokenType("Symbol");
  IElementType SYMBOL_XID = new ValkyrieTokenType("SYMBOL_XID");
  IElementType WHILE = new ValkyrieTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AWARD_STATEMENT) {
        return new ValkyrieAwardStatementNode(node);
      }
      else if (type == BOOLEAN) {
        return new ValkyrieBooleanNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new ValkyrieBraceBlockNode(node);
      }
      else if (type == CALL_SUFFIX) {
        return new ValkyrieCallSuffixNode(node);
      }
      else if (type == CASE_PATTERN) {
        return new ValkyrieCasePatternNode(node);
      }
      else if (type == CONDITION) {
        return new ValkyrieConditionNode(node);
      }
      else if (type == DECLARE_STATEMENT) {
        return new ValkyrieDeclareStatementNode(node);
      }
      else if (type == EF_STATEMENT) {
        return new ValkyrieEfStatementNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ValkyrieElseStatementNode(node);
      }
      else if (type == EVENT_STATEMENT) {
        return new ValkyrieEventStatementNode(node);
      }
      else if (type == EXPRESSION) {
        return new ValkyrieExpressionNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == HERO_STATEMENT) {
        return new ValkyrieHeroStatementNode(node);
      }
      else if (type == IDENTIFIER) {
        return new ValkyrieIdentifierNode(node);
      }
      else if (type == IF_GUARD) {
        return new ValkyrieIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == KW_AWARD) {
        return new ValkyrieKwAwardNode(node);
      }
      else if (type == KW_DECLARE) {
        return new ValkyrieKwDeclareNode(node);
      }
      else if (type == KW_ELSE_IF) {
        return new ValkyrieKwElseIfNode(node);
      }
      else if (type == KW_EVENT) {
        return new ValkyrieKwEventNode(node);
      }
      else if (type == KW_HERO) {
        return new ValkyrieKwHeroNode(node);
      }
      else if (type == KW_VARIABLE) {
        return new ValkyrieKwVariableNode(node);
      }
      else if (type == LIST) {
        return new ValkyrieListNode(node);
      }
      else if (type == MODIFIERS) {
        return new ValkyrieModifiersNode(node);
      }
      else if (type == NAMEPATH) {
        return new ValkyrieNamepathNode(node);
      }
      else if (type == NEW_STATEMENT) {
        return new ValkyrieNewStatementNode(node);
      }
      else if (type == NORMAL_PATTERN) {
        return new ValkyrieNormalPatternNode(node);
      }
      else if (type == NUMBER) {
        return new ValkyrieNumberNode(node);
      }
      else if (type == PATTERN_ITEM) {
        return new ValkyriePatternItemNode(node);
      }
      else if (type == PATTERN_PAIR) {
        return new ValkyriePatternPairNode(node);
      }
      else if (type == PATTERN_VALUE) {
        return new ValkyriePatternValueNode(node);
      }
      else if (type == RANGE) {
        return new ValkyrieRangeNode(node);
      }
      else if (type == SLICE) {
        return new ValkyrieSliceNode(node);
      }
      else if (type == SLICE_ITEM) {
        return new ValkyrieSliceItemNode(node);
      }
      else if (type == STRING) {
        return new ValkyrieStringNode(node);
      }
      else if (type == TRAIT_BLOCK) {
        return new ValkyrieTraitBlockNode(node);
      }
      else if (type == TUPLE) {
        return new ValkyrieTupleNode(node);
      }
      else if (type == TYPE_EXPRESSION) {
        return new ValkyrieTypeExpressionNode(node);
      }
      else if (type == TYPE_GENERIC) {
        return new ValkyrieTypeGenericNode(node);
      }
      else if (type == VARIABLE_STATEMENT) {
        return new ValkyrieVariableStatementNode(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ValkyrieWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
