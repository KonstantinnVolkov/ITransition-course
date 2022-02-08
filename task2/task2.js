const crypto = require('crypto');
const fs = require('fs');

const folderPath = "./files/"
const eMail = 'volkovkonstantinn@gmail.com';
let fileData;

let hashArr = new Array();

// const eMAilHash = crypto.createHash('sha3-256')
//     .update(eMail).digest('hex');
// console.log('email hash: ', eMAilHash.toString());

fs.readdirSync(folderPath).forEach(file => {
    fileData = fs.readFileSync('./files/' + file);
    const hex = crypto.createHash('sha3-256')
        .update(fileData).digest('hex')
    hashArr.push(hex.toLowerCase());
   // console.log(file, hex);
});

hashArr = QuickSort(hashArr);
//console.log(hashArr);

hashStr = hashArr.join('');
hashStr += eMail;
console.log(hashStr);

const result = crypto.createHash('sha3-256')
    .update(hashStr).digest('hex');
console.log('Result: ', result.toString());

function QuickSort(A) {
    if (A.length == 0) return [];
    var a = [], b = [], p = A[0];
    for (var i = 1; i < A.length; i++)
    { if (A[ i ] < p) a[a.length] = A[ i ];
    else b[b.length] = A[ i ];
    }
    return QuickSort(a).concat( p,QuickSort(b) );
}

function BubbleSort(a) {
    var n = a.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - 1 - i; j++) {
            if (a[j+1] < a[j]){
                var t = a[j+1];
                a[j+1] = a[j]
                a[j] = t;
            }
        }
    }
}


