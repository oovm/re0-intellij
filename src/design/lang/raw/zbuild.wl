(* ::Package:: *)

SetDirectory@NotebookDirectory[]


talents = Import["talents.json", "RawJSON"];


talentsNew = StringRiffle[formatTalents /@ (List @@ talents), "\n"];
Export[
    "\:5929\:8d4b.re0",
    talentsNew,
    "Text"
];


translateTalents[t_Association] := Block[
    {exclude},
    exclude = t["exclude"];
    exclude = If[
        MissingQ[exclude],
        "",
        "\:6392\:9664:[\n" <> StringRiffle[talents[ToString@#][["name"]]& /@ t["exclude"], ",\n"] <> "\n]"
    ];
    <|
        "description" -> "/// " <> ToString[t["description"]],
        "name" -> t["name"],
        "exclude" -> exclude
    |>
];


formatTalents[t_Association] := Block[
    {},
    TemplateApply["
`description`
\:5929\:8d4b `name` {
	`exclude`
	`grade`
}
", translateTalents[t]
    ]

];




talents // Values
