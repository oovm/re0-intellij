import { readFileSync, writeFileSync } from "fs";

let achievement = JSON.parse(readFileSync("achievement.json"));
let character = JSON.parse(readFileSync("character.json"));
let events = JSON.parse(readFileSync("events.json"));
let talents = JSON.parse(readFileSync("talents.json"));



let buffer = []


for (const key in talents) {
    const item = talents[key]
    let exclude = item.exclude

    buffer.push(`
/// ${item.description}
天赋 ${item.name} {

    冲突: [
        ${exclude.map(item => `${talents[item]}`).join(",\n")}
    ]
}
    `)
}

writeFileSync('天赋.re0', buffer.join(""), err => {
    if (err) {
        console.error(err);
    }
});