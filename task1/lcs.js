const [ node, file, ...args ] = process.argv;

let n = args.length;
if (n == 0) {
    console.log("")
}
else {
    let firstWord = args[0];
    let firstWordLen = firstWord.length;
    let res = "";

    for (let i = 0; i < firstWordLen; i++) {
        for (let j = i + 1; j <= firstWordLen; j++) {
            let substring = firstWord.substring(i, j);
            let k = 1;
            for (k = 1; k < n; k++) {
                if (!args[k].includes(substring))
                    break;
            }
            if (k == n && res.length < substring.length)
                res = substring;
        }
    }
    console.log(res);
}
