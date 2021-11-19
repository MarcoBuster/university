// Copyright (c) Violetta Lonati, 2021
// https://lonati.di.unimi.it/algopig/2122/materiale/L06_02-client-interfaccia-implementazione-stack.pdf

#ifndef STACK_H
#define STACK_H

#include "item.h"

/* svuota la pila */
void make_empty ( void );

/* restituisce 1 se la pila e’ vuota, 0 altrimenti */
int is_empty ( void );

/* restituisce 1 se la pila e’ piena, 0 altrimenti */
int is_full ( void );

/* se la pila non e’ vuota, restituisce il top della pila;
altrimenti esce con messaggio di errore. */
Item top ( void );

/* se la pila non e’ vuota, estrae il top dalla pila;
altrimenti esce con messaggio di errore. */
Item pop ( void );

/* se c’e’ spazio, aggiunge n alla pila;
altrimenti esce con messaggio d’errore. */
void push ( Item n );

/* stampa il contenuto della pila, partendo dal top. */
void print_stack ( void );
#endif
