// This is a generated file. Not intended for manual editing.
package restart.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static restart.language.psi.RestartTypes.*;
import static restart.language.psi.RestartParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
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
  // kw_archive identifier [modifiers] declare_block
  public static boolean archive_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "archive_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARCHIVE_STATEMENT, "<archive statement>");
    r = kw_archive(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && archive_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean archive_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "archive_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // number | string | boolean | identifier
  static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<brace_free normal_statements SEMICOLON>>
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, RestartParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, BLOCK, r);
    return r;
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
  static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
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
  // BRACKET_L (<<item>>|<<sp>>)* BRACKET_R
  static boolean bracket_free(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_free")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_free_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean bracket_free_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_free_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_free_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "bracket_free_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean bracket_free_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_free_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
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
  // <<brace_free declare_item delimiter>>
  public static boolean declare_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_free(b, l + 1, RestartParser::declare_item, RestartParser::delimiter);
    exit_section_(b, m, DECLARE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // declare_key COLON? declare_block
  //   | declare_key COLON? <<bracket_free normal_statements delimiter>>
  //   | declare_key COLON normal_statements
  public static boolean declare_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARE_ITEM, "<declare item>");
    r = declare_item_0(b, l + 1);
    if (!r) r = declare_item_1(b, l + 1);
    if (!r) r = declare_item_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // declare_key COLON? declare_block
  private static boolean declare_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declare_key(b, l + 1);
    r = r && declare_item_0_1(b, l + 1);
    r = r && declare_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean declare_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item_0_1")) return false;
    consumeToken(b, COLON);
    return true;
  }

  // declare_key COLON? <<bracket_free normal_statements delimiter>>
  private static boolean declare_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declare_key(b, l + 1);
    r = r && declare_item_1_1(b, l + 1);
    r = r && bracket_free(b, l + 1, RestartParser::normal_statements, RestartParser::delimiter);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean declare_item_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item_1_1")) return false;
    consumeToken(b, COLON);
    return true;
  }

  // declare_key COLON normal_statements
  private static boolean declare_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declare_key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && normal_statements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier|number|KW_IF
  public static boolean declare_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARE_KEY, "<declare key>");
    r = identifier(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, KW_IF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // kw_declare identifier [modifiers] declare_block
  public static boolean declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_statement")) return false;
    if (!nextTokenIs(b, "<declare statement>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARE_STATEMENT, "<declare statement>");
    r = kw_declare(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && declare_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
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
  // COMMA|SEMICOLON
  static boolean delimiter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delimiter")) return false;
    if (!nextTokenIs(b, "", COMMA, SEMICOLON)) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // KW_ELSE_IF expression block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    if (!nextTokenIs(b, KW_ELSE_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE_IF);
    r = r && expression(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, EF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ELSE block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
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
  // kw_event identifier [modifiers] declare_block
  public static boolean event_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVENT_STATEMENT, "<event statement>");
    r = kw_event(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && event_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
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
  // op_prefix* atoms (op_suffix|call_suffix|slice)*
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_0(b, l + 1);
    r = r && atoms(b, l + 1);
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

  // (op_suffix|call_suffix|slice)*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|slice
  private static boolean expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = consumeToken(b, SLICE);
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
  // kw_hero identifier [modifiers] declare_block
  public static boolean hero_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hero_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HERO_STATEMENT, "<hero statement>");
    r = kw_hero(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && hero_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
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
  // (KW_IF expression block) [ef_statement* [else_statement]]
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

  // KW_IF expression block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && expression(b, l + 1);
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
  // "award" | "成就"
  public static boolean kw_archive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_archive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_ARCHIVE, "<kw archive>");
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
  public static boolean kw_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_PROPERTY, "<kw property>");
    r = consumeToken(b, "variable");
    if (!r) r = consumeToken(b, "property");
    if (!r) r = consumeToken(b, "属性");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "talent" | "skill" | "装备" | "物品" | "道具" | "天赋" | "技能" | "特质"
  public static boolean kw_talent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_talent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_TALENT, "<kw talent>");
    r = consumeToken(b, "talent");
    if (!r) r = consumeToken(b, "skill");
    if (!r) r = consumeToken(b, "装备");
    if (!r) r = consumeToken(b, "物品");
    if (!r) r = consumeToken(b, "道具");
    if (!r) r = consumeToken(b, "天赋");
    if (!r) r = consumeToken(b, "技能");
    if (!r) r = consumeToken(b, "特质");
    exit_section_(b, l, m, r, false, null);
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
  // if_statement
  //   | expression
  static boolean normal_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_statements")) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BYTE | INTEGER | DECIMAL) [NUMBER_SUFFIX]
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

  // [NUMBER_SUFFIX]
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    consumeToken(b, NUMBER_SUFFIX);
    return true;
  }

  /* ********************************************************** */
  // OP_SET | OP_EQ | OP_NE
  //     | OP_GT | OP_LT | OP_GEQ | OP_LEQ
  //     | OP_ADD | OP_ADD_ASSIGN
  //     | OP_SUB | OP_SUB_ASSIGN
  //     | OP_MUL | OP_MUL_ASSIGN
  //     | OP_DIV | OP_DIV_ASSIGN
  //     | OP_MOD | OP_MOD_ASSIGN
  //     | OP_POW | OP_POW_ASSIGN
  //     | OP_AND | OP_OR
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
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GEQ);
    if (!r) r = consumeToken(b, OP_LEQ);
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
    if (!r) r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_OR);
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
  // OP_ADD | OP_SUB | OP_NOT | BANG
  static boolean op_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_prefix")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_NOT);
    if (!r) r = consumeToken(b, BANG);
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
  // kw_property identifier [modifiers] declare_block
  public static boolean property_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_STATEMENT, "<property statement>");
    r = kw_property(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && property_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean property_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
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
  // kw_talent identifier [modifiers] declare_block
  public static boolean talent_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "talent_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TALENT_STATEMENT, "<talent statement>");
    r = kw_talent(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && talent_statement_2(b, l + 1);
    r = r && declare_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean talent_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "talent_statement_2")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // property_statement
  //   | event_statement
  //   | hero_statement
  //   | archive_statement
  //   | talent_statement
  static boolean top_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statements")) return false;
    boolean r;
    r = property_statement(b, l + 1);
    if (!r) r = event_statement(b, l + 1);
    if (!r) r = hero_statement(b, l + 1);
    if (!r) r = archive_statement(b, l + 1);
    if (!r) r = talent_statement(b, l + 1);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
