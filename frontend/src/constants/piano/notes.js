// "p" indicates a flat note due to poor design choices
const NOTES = [
    'c', 'dp', 'd', 'ep', 'e', 'f', 'gp', 'g', 'ap', 'a', 'bp', 'b',
    'c1', 'd1p', 'd1', 'e1p', 'e1', 'f1', 'g1p', 'g1', 'a1p', 'a1', 'b1p', 'b1'
]

const KEY_TO_NOTE = {
    z: "c",
    s: "dp",
    x: "d",
    d: "ep",
    c: "e",
    v: "f",
    g: "gp",
    b: "g",
    h: "ap",
    n: "a",
    j: "bp",
    m: "b",
    q: "c1",
    2: "d1p",
    w: "d1",
    3: "e1p",
    e: "e1",
    r: "f1",
    5: "g1p",
    t: "g1",
    6: "a1p",
    y: "a1",
    7: "b1p",
    u: "b1",
}

const NOTE_TO_KEY = {
    c: "z",
    dp: "s",
    d: "x",
    ep: "d",
    e: "c",
    f: "v",
    gp: "g",
    g: "b",
    ap: "h",
    a: "n",
    bp: "j",
    b: "m",
    c1: "q",
    d1p: "2",
    d1: "w",
    e1p: "3",
    e1: "e",
    f1: "r",
    g1p: "5",
    g1: "t",
    a1p: "6",
    a1: "y",
    b1p: "7",
    b1: "u",
}

const VALID_KEYS = [ 'z', 's', 'x', 'd', 'c', 'v', 'g', 'b', 'h', 'n', 'j', 'm', 'q', '2', 'w', '3', 'e', 'r', '5', 't', '6', 'y', '7', 'u']

export { NOTES, KEY_TO_NOTE, NOTE_TO_KEY, VALID_KEYS };