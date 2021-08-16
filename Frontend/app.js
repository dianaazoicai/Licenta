'use strict';

const fs = require('fs');
const express =require('express');
const expressLayouts= require('express-ejs-layouts');
const bodyParser = require('body-parser')

const app=express();

const port =2201;

// directorul 'views' va conține fișierele .ejs (html + js executat la server)
app.set('view engine', 'ejs');
// suport pentru layout-uri - implicit fișierul care reprezintă template-ul site-ului este views/layout.ejs
app.use(expressLayouts);
// directorul 'public' va conține toate resursele accesibile direct de către client (e.g., fișiere css, javascript, imagini)
app.use(express.static('public'))
// corpul mesajului poate fi interpretat ca json; datele de la formular se găsesc în format json în req.body
app.use(bodyParser.json());
// utilizarea unui algoritm de deep parsing care suportă obiecte în obiecte
app.use(bodyParser.urlencoded({extended:true}));
let listaPreturi;
fs.readFile('Preturi.json',(err, data)=>{
    if(err) throw err;
    listaPreturi = JSON.parse(data);
});
let listaPreturiAnalize;
fs.readFile('PreturiAnaliza.json',(err,data)=>{
    if(err) throw err;
    listaPreturiAnalize = JSON.parse(data);
});

app.get('/',(req,res)=>res.redirect('/acasa'));
app.get('/acasa',(req,res)=>{
    res.render("acasa");
});
app.get('/programare',(req,res)=>{
    res.render("formular");
});
app.get('/servicii',(req,res)=>{
    res.render("servicii");
});
app.get('/medici',(req,res)=>{
    res.render("medici");
});
app.get('/autentificare',(req,res)=>{
    res.render("autentificare");
});
app.get('/contact',(req,res)=>{
    res.render("contact");
});
app.get('/preturi',(req,res)=>{
    res.render('preturi',{Preturi:listaPreturi,PreturiAnaliza:listaPreturiAnalize});
});
app.get('/termeni',(req,res)=>{
    res.render("termeni");
});

app.post('/test',(req,res)=>{
    

});



app.listen(port,()=>console.log(`Serverul ruleaza la adresa http://localhost:`));