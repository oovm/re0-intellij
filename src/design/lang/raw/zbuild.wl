(* ::Package:: *)

SetDirectory@NotebookDirectory[]


translateEffect[t_Association] := Block[
    {},
    "{\n" <> StringRiffle[{
        If[MissingQ[t["SPR"]], Nothing, "\:5feb\:4e50:" <> ToString@t["SPR"]],
        If[MissingQ[t["MNY"]], Nothing, "\:8d22\:5bcc:" <> ToString@t["MNY"]],
        If[MissingQ[t["CHR"]], Nothing, "\:9b45\:529b:" <> ToString@t["CHR"]],
        If[MissingQ[t["STR"]], Nothing, "\:4f53\:8d28:" <> ToString@t["STR"]],
        If[MissingQ[t["INT"]], Nothing, "\:667a\:529b:" <> ToString@t["INT"]]
    }, ", "] <> "\n}"
];


translateTalents[t_Association] := Block[
    {exclude, effect},
    exclude = t["exclude"];
    exclude = If[
        MissingQ[exclude],
        "",
        "\:6392\:9664:[\n" <> StringRiffle[talents[ToString@#][["name"]]& /@ t["exclude"], ",\n"] <> "\n]"
    ];
    effect = t["effect"];
    effect = If[
        MissingQ[effect],
        "",
        "\:5e38\:9a7b:" <> translateEffect[effect]
    ];
    <|
        "description" -> "/// " <> ToString[t["description"]],
        "name" -> t["name"],
        "exclude" -> exclude,
        "effect" -> effect
    |>
];


formatTalents[t_Association] := Block[
    {},
    TemplateApply["
`description`
\:5929\:8d4b `name` {
	`exclude`
	`grade`
	`effect`
}
", translateTalents[t]
    ]

];




talents = Import["talents.json", "RawJSON"];
talentsNew = StringRiffle[formatTalents /@ (List @@ talents), "\n"];
Export[
    "\:5929\:8d4b.re0",
    talentsNew,
    "Text"
];
