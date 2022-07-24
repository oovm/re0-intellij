// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface RestartTypes {

  IElementType AWARD_STATEMENT = new RestartTokenType("AWARD_STATEMENT");
  IElementType BOOLEAN = new RestartTokenType("BOOLEAN");
  IElementType BRACE_BLOCK = new RestartTokenType("BRACE_BLOCK");
  IElementType CALL_SUFFIX = new RestartTokenType("CALL_SUFFIX");
  IElementType CASE_PATTERN = new RestartTokenType("CASE_PATTERN");
  IElementType CONDITION = new RestartTokenType("CONDITION");
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
  IElementType KW_ELSE_IF = new RestartTokenType("KW_ELSE_IF");
  IElementType KW_EVENT = new RestartTokenType("KW_EVENT");
  IElementType KW_HERO = new RestartTokenType("KW_HERO");
  IElementType KW_VARIABLE = new RestartTokenType("KW_VARIABLE");
  IElementType LIST = new RestartTokenType("LIST");
  IElementType MODIFIERS = new RestartTokenType("MODIFIERS");
  IElementType NAMEPATH = new RestartTokenType("NAMEPATH");
  IElementType NEW_STATEMENT = new RestartTokenType("NEW_STATEMENT");
  IElementType NORMAL_PATTERN = new RestartTokenType("NORMAL_PATTERN");
  IElementType NUMBER = new RestartTokenType("NUMBER");
  IElementType PATTERN_ITEM = new RestartTokenType("PATTERN_ITEM");
  IElementType PATTERN_PAIR = new RestartTokenType("PATTERN_PAIR");
  IElementType PATTERN_VALUE = new RestartTokenType("PATTERN_VALUE");
  IElementType RANGE = new RestartTokenType("RANGE");
  IElementType SLICE = new RestartTokenType("SLICE");
  IElementType SLICE_ITEM = new RestartTokenType("SLICE_ITEM");
  IElementType STRING = new RestartTokenType("STRING");
  IElementType TRAIT_BLOCK = new RestartTokenType("TRAIT_BLOCK");
  IElementType TUPLE = new RestartTokenType("TUPLE");
  IElementType TYPE_EXPRESSION = new RestartTokenType("TYPE_EXPRESSION");
  IElementType TYPE_GENERIC = new RestartTokenType("TYPE_GENERIC");
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
  IElementType COMMENT = new RestartTokenType("Comment");
  IElementType DECIMAL = new RestartTokenType("DECIMAL");
  IElementType DOT = new RestartTokenType(".");
  IElementType DOT2 = new RestartTokenType("DOT2");
  IElementType DOT3 = new RestartTokenType("DOT3");
  IElementType DOT_EQ = new RestartTokenType("DOT_EQ");
  IElementType DOT_LESS = new RestartTokenType("DOT_LESS");
  IElementType INTEGER = new RestartTokenType("INTEGER");
  IElementType KW_FOR = new RestartTokenType("KW_FOR");
  IElementType KW_IF = new RestartTokenType("KW_IF");
  IElementType NEW = new RestartTokenType("NEW");
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