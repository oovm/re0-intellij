// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.valkyrie.language.psi.RestartTypes.*;
import static com.github.valkyrie.language.psi.RestartParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RestartParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return re0(b, l + 1);
  }

  /* ********************************************************** */
  // OP_LT [<<item>> (<<sp>> <<item>>)* [<<sp>>]] OP_GT
  static boolean angle_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block")) return false;
    if (!nextTokenIs(b, OP_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LT);
    r = r && angle_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean angle_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1")) return false;
    angle_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean angle_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && angle_block_1_0_1(b, l + 1, _sp, _item);
    r = r && angle_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean angle_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!angle_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "angle_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean angle_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean angle_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // number | string | boolean | namepath
  static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = namepath(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // kw_award identifier [modifiers] <<brace_block kw_declare COMMA>>
  public static boolean award_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "award_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AWARD_STATEMENT, "<award statement>");
    r = kw_award(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && award_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RestartParser::kw_declare, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean award_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "award_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block expression SEMICOLON>>
  static boolean block(PsiBuilder b, int l) {
    return brace_block(b, l + 1, RestartParser::expression, SEMICOLON_parser_);
  }

  /* ********************************************************** */
  // "true" | "false"
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, BRACE_BLOCK, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    brace_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && brace_block_1_0_1(b, l + 1, _sp, _item);
    r = r && brace_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean brace_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean brace_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean brace_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  static boolean brace_free(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_free_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_free_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_free_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_free_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_free_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_free_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean call_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, RestartParser::expression, COMMA_parser_);
    exit_section_(b, m, CALL_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // CASE [identifier* [namepath]] pattern
  public static boolean case_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && case_pattern_1(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, CASE_PATTERN, r);
    return r;
  }

  // [identifier* [namepath]]
  private static boolean case_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1")) return false;
    case_pattern_1_0(b, l + 1);
    return true;
  }

  // identifier* [namepath]
  private static boolean case_pattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern_1_0_0(b, l + 1);
    r = r && case_pattern_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean case_pattern_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_pattern_1_0_0", c)) break;
    }
    return true;
  }

  // [namepath]
  private static boolean case_pattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_1")) return false;
    namepath(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // case_pattern OP_SET expression | expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // case_pattern OP_SET expression
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, OP_SET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_declare identifier [modifiers] <<brace_block kw_declare COMMA>>
  public static boolean declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_statement")) return false;
    if (!nextTokenIs(b, "<declare statement>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARE_STATEMENT, "<declare statement>");
    r = kw_declare(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && declare_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RestartParser::kw_declare, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean declare_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_else_if condition block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EF_STATEMENT, "<ef statement>");
    r = kw_else_if(b, l + 1);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "else" block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, "<else statement>");
    r = consumeToken(b, "else");
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON|OP_PROPORTION|SEMICOLON|
  //     BRACKET_L|BRACKET_R|PARENTHESIS_L|PARENTHESIS_R|
  //     COMMA|OP_EQ|DOT
  static boolean end_m1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_m1")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, BRACKET_L);
    if (!r) r = consumeToken(b, BRACKET_R);
    if (!r) r = consumeToken(b, PARENTHESIS_L);
    if (!r) r = consumeToken(b, PARENTHESIS_R);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, DOT);
    return r;
  }

  /* ********************************************************** */
  // kw_event identifier [modifiers] <<brace_block kw_declare COMMA>>
  public static boolean event_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVENT_STATEMENT, "<event statement>");
    r = kw_event(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && event_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RestartParser::kw_declare, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean event_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // op_prefix* term (op_suffix|call_suffix|type_generic|slice)*
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_0(b, l + 1);
    r = r && term(b, l + 1);
    r = r && expr_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // op_prefix*
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_0", c)) break;
    }
    return true;
  }

  // (op_suffix|call_suffix|type_generic|slice)*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|type_generic|slice
  private static boolean expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = type_generic(b, l + 1);
    if (!r) r = slice(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // expr (op_binary expr)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expr(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary expr)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // op_binary expr
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_FOR (case_pattern|normal_pattern) KW_IF expression [if_guard] block [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FOR);
    r = r && for_statement_1(b, l + 1);
    r = r && consumeToken(b, KW_IF);
    r = r && expression(b, l + 1);
    r = r && for_statement_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && for_statement_6(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // case_pattern|normal_pattern
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    boolean r;
    r = case_pattern(b, l + 1);
    if (!r) r = normal_pattern(b, l + 1);
    return r;
  }

  // [if_guard]
  private static boolean for_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_4")) return false;
    if_guard(b, l + 1);
    return true;
  }

  // [else_statement]
  private static boolean for_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_6")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_hero identifier [modifiers] <<brace_block kw_declare COMMA>>
  public static boolean hero_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hero_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HERO_STATEMENT, "<hero statement>");
    r = kw_hero(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && hero_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RestartParser::kw_declare, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean hero_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hero_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL_XID | SYMBOL_RAW
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, "<identifier>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_IF condition
  public static boolean if_guard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_guard")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && condition(b, l + 1);
    exit_section_(b, m, IF_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // (KW_IF condition block) [ef_statement* [else_statement]]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_0(b, l + 1);
    r = r && if_statement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // KW_IF condition block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ef_statement* [else_statement]]
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    if_statement_1_0(b, l + 1);
    return true;
  }

  // ef_statement* [else_statement]
  private static boolean if_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_1_0_0(b, l + 1);
    r = r && if_statement_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ef_statement*
  private static boolean if_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ef_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_1_0_0", c)) break;
    }
    return true;
  }

  // [else_statement]
  private static boolean if_statement_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_1")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "award"|"成就"
  public static boolean kw_award(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_award")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_AWARD, "<kw award>");
    r = consumeToken(b, "award");
    if (!r) r = consumeToken(b, "成就");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean kw_declare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_declare")) return false;
    if (!nextTokenIs(b, "<kw declare>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_DECLARE, "<kw declare>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "else" KW_IF | "ef"
  public static boolean kw_else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_ELSE_IF, "<kw else if>");
    r = kw_else_if_0(b, l + 1);
    if (!r) r = consumeToken(b, "ef");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "else" KW_IF
  private static boolean kw_else_if_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_else_if_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && consumeToken(b, KW_IF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "event" | "事件"
  public static boolean kw_event(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_event")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_EVENT, "<kw event>");
    r = consumeToken(b, "event");
    if (!r) r = consumeToken(b, "事件");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "character" | "hero" | "人物" | "英雄"
  public static boolean kw_hero(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_hero")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_HERO, "<kw hero>");
    r = consumeToken(b, "character");
    if (!r) r = consumeToken(b, "hero");
    if (!r) r = consumeToken(b, "人物");
    if (!r) r = consumeToken(b, "英雄");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "variable" | "property" | "属性"
  public static boolean kw_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_VARIABLE, "<kw variable>");
    r = consumeToken(b, "variable");
    if (!r) r = consumeToken(b, "property");
    if (!r) r = consumeToken(b, "属性");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block expression COMMA>>
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, RestartParser::expression, COMMA_parser_);
    exit_section_(b, m, LIST, r);
    return r;
  }

  /* ********************************************************** */
  // (identifier !end_m1)+
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    if (!nextTokenIs(b, "<modifiers>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERS, "<modifiers>");
    r = modifiers_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!modifiers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifiers", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier !end_m1
  private static boolean modifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && modifiers_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !end_m1
  private static boolean modifiers_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !end_m1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (OP_PROPORTION identifier)*
  public static boolean namepath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath")) return false;
    if (!nextTokenIs(b, "<namepath>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
    r = identifier(b, l + 1);
    r = r && namepath_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_PROPORTION identifier)*
  private static boolean namepath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
    }
    return true;
  }

  // OP_PROPORTION identifier
  private static boolean namepath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PROPORTION);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NEW modifiers [type_generic] [COLON type_expression] trait_block
  public static boolean new_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && modifiers(b, l + 1);
    r = r && new_statement_2(b, l + 1);
    r = r && new_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, NEW_STATEMENT, r);
    return r;
  }

  // [type_generic]
  private static boolean new_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2")) return false;
    type_generic(b, l + 1);
    return true;
  }

  // [COLON type_expression]
  private static boolean new_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_3")) return false;
    new_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean new_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* pattern | <<sequence pattern_item COMMA>>
  public static boolean normal_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NORMAL_PATTERN, "<normal pattern>");
    r = normal_pattern_0(b, l + 1);
    if (!r) r = sequence(b, l + 1, RestartParser::pattern_item, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* pattern
  private static boolean normal_pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_pattern_0_0(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean normal_pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_pattern_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // if_statement
  //   | for_statement
  //   | while_statement
  //   | new_statement
  //   | expression
  static boolean normal_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_statements")) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = new_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BYTE | INTEGER | DECIMAL) [identifier]
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_0(b, l + 1);
    r = r && number_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BYTE | INTEGER | DECIMAL
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    boolean r;
    r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // [identifier]
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OP_SET | OP_EQ | OP_NE
  //     | OP_ADD | OP_ADD_ASSIGN
  //     | OP_SUB | OP_SUB_ASSIGN
  //     | OP_MUL | OP_MUL_ASSIGN
  //     | OP_DIV | OP_DIV_ASSIGN | OP_MOD | OP_MOD_ASSIGN
  //     | OP_POW | OP_POW_ASSIGN
  //     | OP_GT | OP_LT | DOT_LESS | DOT_EQ | DOT2 | DOT
  //     | OP_TO
  //     | OP_AND_THEN | OP_OR_ELSE
  //     // is | is not
  //     | OP_NOT_A | OP_IS_A OP_NOT | OP_IS_A | OP_NOT OP_IS_A
  //     | OP_AS
  //     // in | not in
  //     | OP_IN | OP_NOT_IN | OP_NOT OP_IN
  static boolean op_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SET);
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, OP_NE);
    if (!r) r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_ADD_ASSIGN);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_SUB_ASSIGN);
    if (!r) r = consumeToken(b, OP_MUL);
    if (!r) r = consumeToken(b, OP_MUL_ASSIGN);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_DIV_ASSIGN);
    if (!r) r = consumeToken(b, OP_MOD);
    if (!r) r = consumeToken(b, OP_MOD_ASSIGN);
    if (!r) r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_POW_ASSIGN);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, DOT_LESS);
    if (!r) r = consumeToken(b, DOT_EQ);
    if (!r) r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_TO);
    if (!r) r = consumeToken(b, OP_AND_THEN);
    if (!r) r = consumeToken(b, OP_OR_ELSE);
    if (!r) r = consumeToken(b, OP_NOT_A);
    if (!r) r = parseTokens(b, 0, OP_IS_A, OP_NOT);
    if (!r) r = consumeToken(b, OP_IS_A);
    if (!r) r = parseTokens(b, 0, OP_NOT, OP_IS_A);
    if (!r) r = consumeToken(b, OP_AS);
    if (!r) r = consumeToken(b, OP_IN);
    if (!r) r = consumeToken(b, OP_NOT_IN);
    if (!r) r = parseTokens(b, 0, OP_NOT, OP_IN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_ADD | OP_SUB | OP_NOT | BANG | AMP | DOT3 | DOT2
  static boolean op_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_prefix")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_NOT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, AMP);
    if (!r) r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  /* ********************************************************** */
  // BANG | QUESTION
  static boolean op_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_suffix")) return false;
    if (!nextTokenIs(b, "", BANG, QUESTION)) return false;
    boolean r;
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, QUESTION);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && parenthesis_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean parenthesis_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1")) return false;
    parenthesis_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && parenthesis_1_0_1(b, l + 1, _sp, _item);
    r = r && parenthesis_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parenthesis_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean parenthesis_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis   pattern_pair COMMA>>
  //   | <<bracket_block pattern_pair COMMA>>
  //   | <<brace_block   pattern_pair COMMA>>
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, RestartParser::pattern_pair, COMMA_parser_);
    if (!r) r = bracket_block(b, l + 1, RestartParser::pattern_pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, RestartParser::pattern_pair, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_ITEM, "<pattern item>");
    r = pattern_item_0(b, l + 1);
    if (!r) r = pattern_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_item_0_0(b, l + 1);
    r = r && pattern_item_0_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_0_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* COLON pattern_value | identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_PAIR, "<pattern pair>");
    r = pattern_pair_0(b, l + 1);
    if (!r) r = pattern_pair_1(b, l + 1);
    if (!r) r = pattern_pair_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* COLON pattern_value
  private static boolean pattern_pair_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && pattern_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_0_0", c)) break;
    }
    return true;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_pair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_1_0(b, l + 1);
    r = r && pattern_pair_1_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_1_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_pair_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_pair_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier | pattern
  public static boolean pattern_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_VALUE, "<pattern value>");
    r = identifier(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<slice_block slice_item COMMA>>
  public static boolean range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_block(b, l + 1, RestartParser::slice_item, COMMA_parser_);
    exit_section_(b, m, RANGE, r);
    return r;
  }

  /* ********************************************************** */
  // ((top_statements|normal_statements) [SEMICOLON])*
  static boolean re0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "re0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!re0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "re0", c)) break;
    }
    return true;
  }

  // (top_statements|normal_statements) [SEMICOLON]
  private static boolean re0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "re0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = re0_0_0(b, l + 1);
    r = r && re0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // top_statements|normal_statements
  private static boolean re0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "re0_0_0")) return false;
    boolean r;
    r = top_statements(b, l + 1);
    if (!r) r = normal_statements(b, l + 1);
    return r;
  }

  // [SEMICOLON]
  private static boolean re0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "re0_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  static boolean sequence(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && sequence_1(b, l + 1, _sp, _item);
    r = r && sequence_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean sequence_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sequence_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "sequence_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean sequence_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean sequence_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<slice_block slice_item COMMA>>
  public static boolean slice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_block(b, l + 1, RestartParser::slice_item, COMMA_parser_);
    exit_section_(b, m, SLICE, r);
    return r;
  }

  /* ********************************************************** */
  // SLICE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] SLICE_R
  static boolean slice_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block")) return false;
    if (!nextTokenIs(b, SLICE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLICE_L);
    r = r && slice_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, SLICE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean slice_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1")) return false;
    slice_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean slice_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && slice_block_1_0_1(b, l + 1, _sp, _item);
    r = r && slice_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean slice_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "slice_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!slice_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "slice_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean slice_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "slice_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean slice_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "slice_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // [expression] COLON [expression] COLON [expression]
  //   | [expression] COLON [expression]
  //   | [expression] OP_PROPORTION [expression]
  //   | expression
  public static boolean slice_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLICE_ITEM, "<slice item>");
    r = slice_item_0(b, l + 1);
    if (!r) r = slice_item_1(b, l + 1);
    if (!r) r = slice_item_2(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [expression] COLON [expression] COLON [expression]
  private static boolean slice_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_0_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_0_4")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] COLON [expression]
  private static boolean slice_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_1_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_item_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_1_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] OP_PROPORTION [expression]
  private static boolean slice_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_item_2_0(b, l + 1);
    r = r && consumeToken(b, OP_PROPORTION);
    r = r && slice_item_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_item_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_item_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_item_2_2")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [identifier] STRING_START STRING_TEXT STRING_END
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    r = r && consumeTokens(b, 0, STRING_START, STRING_TEXT, STRING_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier]
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // range | list | tuple | atoms
  static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    r = range(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = atoms(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // variable_statement
  //   | event_statement
  //   | hero_statement
  //   | award_statement
  //   | declare_statement
  static boolean top_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statements")) return false;
    boolean r;
    r = variable_statement(b, l + 1);
    if (!r) r = event_statement(b, l + 1);
    if (!r) r = hero_statement(b, l + 1);
    if (!r) r = award_statement(b, l + 1);
    if (!r) r = declare_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<brace_free top_statements SEMICOLON>>
  public static boolean trait_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, RestartParser::top_statements, SEMICOLON_parser_);
    exit_section_(b, m, TRAIT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, RestartParser::expression, COMMA_parser_);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // op_prefix* term (op_suffix|call_suffix|type_generic|slice)*
  static boolean type_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_expr_0(b, l + 1);
    r = r && term(b, l + 1);
    r = r && type_expr_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // op_prefix*
  private static boolean type_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_0", c)) break;
    }
    return true;
  }

  // (op_suffix|call_suffix|type_generic|slice)*
  private static boolean type_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|type_generic|slice
  private static boolean type_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = type_generic(b, l + 1);
    if (!r) r = slice(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // type_expr (op_binary type_expr)*
  public static boolean type_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
    r = type_expr(b, l + 1);
    r = r && type_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary type_expr)*
  private static boolean type_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expression_1", c)) break;
    }
    return true;
  }

  // op_binary type_expr
  private static boolean type_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block ([identifier COLON] type_expression) COMMA>>
  public static boolean type_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, RestartParser::type_generic_0_0, COMMA_parser_);
    exit_section_(b, m, TYPE_GENERIC, r);
    return r;
  }

  // [identifier COLON] type_expression
  private static boolean type_generic_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_generic_0_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean type_generic_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0_0")) return false;
    type_generic_0_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean type_generic_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_variable identifier [modifiers] <<brace_block kw_declare COMMA>>
  public static boolean variable_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_STATEMENT, "<variable statement>");
    r = kw_variable(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && variable_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RestartParser::kw_declare, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean variable_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WHILE condition block
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
