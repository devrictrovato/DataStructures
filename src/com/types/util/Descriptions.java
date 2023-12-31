package com.types.util;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.types.panels.Layout;

/*
 * Montar as explicações dos TADs e os demais paineis
 */
public final class Descriptions {

	// Contéudo da descrição
	private static JTextPane desc;

	// Layout das descrições
	private static Layout layout = new Layout();

	// Descrição do painel Lista de Arranjos
	public static void descriptionArrayList(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Arranjo</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Uma <strong>Lista Arranjo</strong> é uma coleção <b>L</b> de <b>N</b> elementos armazenados de maneira\r\n" + 
						"        sequencial (um seguido do outro) de forma que o primeiro elemento esteja no índice <b>0</b> e o último elemento\r\n" + 
						"        esteja no índice <b>n-1</b>.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        A ordem de seus elementos é de acordo com o valor que cada um guarda, o elemento de maior valor ficar na\r\n" + 
						"        primeira posição e o elemento de menor valor fica na última posição.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos contidos na lista.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a lista estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>add(i, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o elemento <b>e</b> no índice <b>i</b> da coleção <b>L</b>.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Se já existir um elemento no índice <b>i</b>, este elemento é movido um índice para a direita da\r\n" + 
						"                    coleção, este processo ocorre enquanto houver um elemento a direita, isso é feito para liberar\r\n" + 
						"                    espaço no índice informado para adicionar o elemento <b>e</b>.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Um erro ocorre quando <b>i</b> é menor que 0 (zero) ou maior que o tamanho da coleção <b>L</b> - 1.\r\n" + 
						"                </p>\r\n" + 
						"                <!-- <p>Adiciona o elemento <b>e</b> na coleção.</p>\r\n" + 
						"                <p>\r\n" + 
						"                    Caso a coleção esteja cheia e o elemento <b>e</b> tiver o menor valor, então ele <b>não</b> será\r\n" + 
						"                    adicionado a coleção pois não tem um valor alto suficiente para pelo menos passar do último\r\n" + 
						"                    elemento, mas se o elemento <b>e</b> tiver um valor que seja pelo menos maior que o último elemento,\r\n" + 
						"                    então, <b>e</b> será adicionado a coleção e o menor elemento dela será descartado.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Caso a coleção não esteja cheia, o elemento <b>e</b> será adicionado a coleção em uma posição\r\n" + 
						"                    relativa ao seu valor.\r\n" + 
						"                </p> -->\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>remove(i)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove o elemento que está no índice <b>i</b> da coleção <b>L</b>.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Caso existam elementos a direita do índice <b>i</b>, esses elementos seram movidos um índice para a\r\n" + 
						"                    esquerda. Evitando que fique um espaço em branco no meio da coleção.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Um erro ocorre quando <b>i</b> é menor que 0 (zero) ou maior que o tamanho da coleção <b>L</b> - 1.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>get(i)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o elemento que está no índice <b>i</b> da coleção <b>L</b>.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Um erro ocorre quando <b>i</b> é menor que 0 (zero) ou maior que o tamanho da coleção <b>L</b> - 1.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>set(i, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Substitui o elemento que está no índice <b>i</b> da coleção <b>L</b> pelo elemento <b>e</b>, depois\r\n" + 
						"                    disso, retorna o elemento que estava antes da substituição acontecer.\r\n" + 
						"                </p>\r\n" + 
						"                <p>\r\n" + 
						"                    Um erro ocorre quando <b>i</b> é menor que 0 (zero) ou maior que o tamanho da coleção <b>L</b> - 1.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>",
						panel
				);
	}

	// Descrição do painel Pilha
	public static void descriptionStack(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Pilha</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Uma pilha <b>P</b> é uma coleção de <b>N</b> elementos supostamente colocados um em cima do outro, como em uma\r\n" + 
						"        pilha de pratos, onde, o último a entrar é o primeiro a sair (LIFO - Last In, First Out).\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Ao adicionar um elemento em <b>P</b>, este ficará no topo da pilha. Ao tirar um elemento de <b>P</b>, o elemento\r\n" + 
						"        tirado será aquele que está no topo.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos contidos na pilha.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a pilha estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>push(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o elemento <b>e</b> no topo da pilha.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>pop()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove o elemento que está no topo da pilha e o retorna. Um erro ocorre se a pilha estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>top()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o elemento que está no topo da pilha sem removê-lo. Um erro ocorre se a pilha estiver\r\n" + 
						"                    vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>",
						panel
				);
	}

	// Descrição do painel Fila
	public static void descriptionQueue(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Fila</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Uma fila <b>F</b> é uma coleção de <b>N</b> elementos ordenados um após o outro, como em uma fila, onde, o\r\n" + 
						"        primeiro a entrar é o primeiro a sair (FIFO - First In, First Out).\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Ao adicionar um elemento em <b>F</b>, este ficará no final da fila. Ao tirar um elemento de <b>F</b>, o elemento\r\n" + 
						"        tirado será aquele mais antigo na fila, ou seja, o que chegou primeiro em relação aos outros elementos.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos contidos na fila.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a fila estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>enqueue(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o elemento <b>e</b> no final da fila.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>dequeue()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove o elemento que está na frente da fila e o retorna. Um erro ocorre se a fila estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>front()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o elemento que está na frente da fila sem removê-lo. Um erro ocorre se a fila estiver\r\n" + 
						"                    vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>",
						panel
				);
	}

	// Descrição do painel Lista de Nodos
	public static void descriptionNodePositionList(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Lista de Nodos</h1>\r\n" + 
						"</section>" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        <strong>Lista de Nodos</strong> é um pouco diferente de <strong>Lista de Arranjo</strong>, aqui, a lista é\r\n" + 
						"        formada por elementos sem índices, eles são armazenados de maneira que eles saibam quem são seus vizinhos, ou\r\n" + 
						"        seja, um nodo sabe quem está antes dele e quem está depois dele.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Assim, podemos percorrer a lista visitando o vizinho sucessor de um nodo, isso\r\n" + 
						"        se repete até que não tenha mais nenhum vizinho para visitar, e assim, percorremos toda a lista.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos contidos na lista.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a lista estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>first()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna a posição do primeiro nodo da lista. Um erro ocorre se a lista estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>last()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna a posição do último nodo da lista. Um erro ocorre se a lista estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>prev(p)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o nodo que está diretamente antes do nodo na posição <b>p</b>. Um erro ocorre se <b>p</b>\r\n" + 
						"                    for a primeira posição, ou se a lista estiver vazia pois neste caso a posição <b>p</b> não\r\n" + 
						"                    existiria.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>next(p)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o nodo que está diretamente depois do nodo na posição <b>p</b>. Um erro ocorre se <b>p</b>\r\n" + 
						"                    for a última posição, ou se a lista estiver vazia pois neste caso a posição <b>p</b> não existiria.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>set(p, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Substitui o nodo que está na posição <b>p</b> pelo nodo <b>e</b>, após isso, o nodo que estava na\r\n" + 
						"                    posição <b>p</b> antes da substituição, é retornado.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>addFirst(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o nodo <b>e</b> na primeira posição.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>addLast(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o nodo <b>e</b> na última posição.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>addBefore(p, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o nodo <b>e</b> diretamente antes da posição <b>p</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>addAfter(p, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona o nodo <b>e</b> diretamente depois da posição <b>p</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>remove(p)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove o nodo que está na posição <b>p</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>",
						panel
				);
	}

	// Descrição do painel Árvore Genérica
	public static void descriptionGenericTree(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Árvore Genérica</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Seus elementos são organizados de maneira hierárquica, como uma árvore de cabeça para baixo. Com a exceção da\r\n" + 
						"        raiz (o primeiro elemento) todos os elementos tem <b>um</b> pai (que está acima) e no mínimo 0 filhos (que estão\r\n" + 
						"        abaixo). A ligação de um pai com seus filhos é desenhada com linhas, saindo do pai e ligando com cada filho.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de nodos contidos na árvore.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a árvore estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>root()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna a raiz da árvore. Um erro ocorre se a árvore estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>parent(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o nodo pai de <b>v</b>. Um erro ocorre se <b>v</b> for a raiz.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>children(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável dos filhos de <b>v</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isInternal(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna true se <b>v</b> for um nodo interno da árvore, o seja, se ele tiver um pai e ao menos 1\r\n" + 
						"                    filho.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>isExternal(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna true se <b>v</b> for um nodo externo da árvore, ou seja, se ele tiver um pai e nenhum\r\n" + 
						"                    filho.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isRoot(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna true se <b>v</b> for a da árvore.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>iterator()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna um iterador de todos os elementos armazenados nos nodos da árvore.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>positions()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável com todos os nodos da árvore.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>replace(v, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Substitui o elemento armazenado em <b>v</b> por <b>e</b> e retorna o elemento que estava em <b>v</b>\r\n" + 
						"                    antes da substituição.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>", 
						panel
				);
	}

	// Descrição do painel Árvore Binária
	public static void descriptionBinaryTree(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Árvore Binária</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        É parecida com a <strong>Árvore Genérica</strong> mas na <strong>Árvore Binária</strong> os pais só podem ter no\r\n" + 
						"        máximo 2 filhos, o filho da esquerda e o filho da direita.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        O nome <strong>Árvore Binária própria</strong> é dado a árvore que tem 0 <b>ou</b> 2 filhos em cada nodo. Caso\r\n" + 
						"        contrário, a árvore é nomeada de <strong>Árvore Binária imprópria</strong>.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos contidos na aaa.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a aaa estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>left(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o filho esquerdo do nodo <b>v</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>right(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o filho direito do nodo <b>v</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>hasLeft(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Verifica se o nodo <b>v</b> tem um filho a esquerda.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>hasRight(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Verifica se o nodo <b>v</b> tem um filho a direita.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>addRoot(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o filho esquerdo do nodo <b>v</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>insertLeft(v, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o filho direito do nodo <b>v</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>insertRight(v, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Verifica se o nodo <b>v</b> tem um filho a esquerda.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>remove(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Verifica se o nodo <b>v</b> tem um filho a direita.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>attach(v, T1, T2)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Conecta a árvore <b>T1</b> a esquerda de <b>v</b> e a árvore <b>T2</b> a direita de <b>v</b>,\r\n" + 
						"                    fazendo com que <b>T1</b> seja uma subárvore esquerda de <b>v</b> e <b>T2</b> seja uma subárvore\r\n" + 
						"                    direita de <b>v</b>. Para isso, o nodo <b>v</b> deve ser externo, então, um erro ocorre se ele não\r\n" + 
						"                    for.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>", 
						panel
				);
	}

	// Descrição do painel Fila de Prioridade
	public static void descriptionPriorityQueue(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Fila de Prioridade</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Esta fila não usa posições para se orientar, mas sim valores que significam níveis de proioridade, ao adicionar\r\n" + 
						"        um elemento na fila, este é chamado de <strong>entrada</strong>, possuindo uma <b>chave</b> e um <b>valor</b>, a\r\n" + 
						"        chave é o nível de prioridade que a entrada tem ao fazer uma remoção na lista.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Sendo assim, o processo de adicionar não tem nada demais, mas o processo de remover, envolver em verificar qual\r\n" + 
						"        entrada tem a maior ou a menor chave, depende muito da finalidade.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Para saber qual é a maior ou a menor chave, uma lógica de comparação é usada, verificando se <b>x</b> é maior\r\n" + 
						"        que <b>y</b>, ou o contrário, ou até mesmo se são iguais.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de entradas contidas na fila.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a fila estiver vazia ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>min()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    <b>Sem remover da fila</b>, esta função retorna a entrada que contem a menor chave. Um erro ocorre\r\n" + 
						"                    se a fila estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>insert(k, x)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Adiciona uma entrada na fila contendo a chave <b>k</b> e o valor <b>x</b>, um erro ocorre se\r\n" + 
						"                    <b>k</b> for uma chave que não pode ser comparada com as demais.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>removeMin()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove e retorna a entrada que contem a menor chave da fila. Um erro ocorre se a fila estiver vazia.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>compare(a, b)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Compara as chaves <b>a</b> e <b>b</b>. Se <b>a</b>\r\n" + 
						"                    &#60; <b>b</b> então retorna <b>-1</b>. Se <b>a</b> = <b>b</b> então retorna 0. Se <b>a</b> > <b>b</b>\r\n" + 
						"                        então retorna <b>1</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>", 
						panel
				);
	}

	// Descrição do painel Mapa
	public static void descriptionMap(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Mapa</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        <strong>Mapas</strong> armazenam entradas, assim como <strong>Fila de Prioridade</strong> mas neste caso as\r\n" + 
						"        chaves não serão usadas para comparação mas sim para pesquisa, com isso, uma entrada pode ser localizada\r\n" + 
						"        rapidamente dentro do mapa.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de entradas de <b>M</b>;\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Testa se <b>M</b> está vazio;\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>get(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Se <b>M</b> contém uma entrada <b>e</b> com chave igual a <b>k</b>, então retorna o valor de <b>e</b>, senão" + 
						"                    retorna <b>null</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>put(k, v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Se <b>M</b> não tem uma entrada com chave igual a <b>k</b>, então adiciona a entrada (<b>k</b>,<b>v</b>) em" + 
						"                    <b>M</b> e retorna <b>null</b>; senão, substitui o valor existente com <b>v</b> com chave <b>k</b> e retorna o" + 
						"                    valor antigo;\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>remove(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove a entrada de <b>M</b> com chave igual a <b>k</b>, e retorna seu valor; se <b>M</b> não possui a" + 
						"                    entrada com chave <b>k</b>, então retorna <b>null</b>;\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>keySet(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    retorna uma coleção iterável contendo todas as chaves armazenadas em <b>M</b> (assim" + 
						"                    keySet ().iterator() retorna um iterator das chaves);\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>values()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    retorna uma coleção contendo todos os valores associados com as chaves\r\n" + 
						"                    armazenadas em <b>M</b> (assim values( ).iterator() retorna um iterator dos valores);\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>entrySets()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    retorna uma coleção contendo todas as entradas (chave-valor) de <b>M</b> (assim\r\n" + 
						"                    entrySet( ).iterator() retorna um iterator das entradas).\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>", 
						panel
				);
	}

	// Descrição do painel Dicionário
	public static void descriptionDictionary(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Dicionário</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Assim como <strong>Mapas</strong>, <strong>Dicionários</strong> armazenam entradas, porém, com uma diferença,\r\n" + 
						"        <strong>Dicionários</strong> permitem mais de uma entrada com a mesma chave.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Operações</h2>\r\n" + 
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de elementos de <b>D</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Testa se <b>D</b> está vazio.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>get(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Se <b>D</b> contém um elemento com chave igual a <b>k</b>, então retorna o elemento,\r\n"
						+ "senão retorna null.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>getAll(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável contendo todos os elementos com chave igual a\r\n"
						+ "<b>k</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>put(k, v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Insere um elemento com chave <b>k</b> e valor <b>v</b> no dicionário <b>D</b>, retornando o\r\n"
						+ "elemento criado.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>remove(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove de <b>D</b> um elemento <b>e</b>, retornando o elemento removido, senão\r\n"
						+ "retorna <b>null</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>entrySet()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável dos elementos chave-valor de <b>D</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>", 
						panel
				);
	}

	// Descrição do painel Mapa ABB
	public static void descriptionABB(JPanel panel) {
		String putabbimg = panel.getClass().getClassLoader().getResource("putabb.jpg").toString();
		String remabb1 = panel.getClass().getClassLoader().getResource("remabb1.jpg").toString();
		String remabb2 = panel.getClass().getClassLoader().getResource("remabb2.jpg").toString();
		setDescription(
				"<section>\r\n" + 
						"    <h1>Mapa Ordenado - Árvore Binária de Busca</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Implementa árvores para facilitar a busca por elementos. Herda algumas operações do <strong>TAD Mapa</strong>,\r\n" + 
						"        que são: get(k), put(k, v) e remove(k).\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Seu mecanismo de busca envolve os antecessores e os sucessores da chave\r\n" + 
						"        desempenhando de acordo a uma busca sequencial e sua importância permanece\r\n" + 
						"        com uma relação de ordem em suas chaves\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Sua <b>pesquisa</b> consiste em algoritmos de busca adaptados para melhor execução\r\n" +
						"        mais conhecidos como: <b>preorder</b>, <b>inorder</b>, <b>posorder</b>.\r\n" +
						"    </p>\r\n" + 
						"</section>\r\n" +
						"<section>\r\n" +
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de entradas contidas na arvore de busca.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a arvore de busca estiver vazio ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>get(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Pesquisa por uma entrada que tenha a chave igual a <b>k</b>, caso encontre, retorna o valor contido\r\n" + 
						"                    na entrada, caso não encontre, retorna <b>null</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>put(k, v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"					 <img src='"+ putabbimg +"'>\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>remove(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"					 <p><img src='"+ remabb1 +"'></p>\r\n" +
						"					 <p><img src='"+ remabb2 +"'></p>\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>search(k, p)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Pesquisa a chave <b>k</b> na arvore ate encontrar a posição <b>p</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>\r\n"
						, 
						panel
				);
	}

	// Descrição do painel Mapa AVL
	public static void descriptionAVL(JPanel panel) {
		String putavlimg = panel.getClass().getClassLoader().getResource("putavl.jpg").toString();
		String remavlimg = panel.getClass().getClassLoader().getResource("remavl.jpg").toString();
		setDescription(
				"<section>\r\n" + 
						"    <h1>Mapa Ordenado - AVL</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        Esta arvore é uma <strong>TAD Arvore Binaria</strong>\r\n" + 
						"        criada para evitar problemas de inserção de chaves dependendo de suas insersoes.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Essa correção assume uma regra, onde ela devera manter sua altura <b>balanceada</b>\r\n" + 
						"        obtendo uma reestruturacao e mantendo a ordem das chaves proposto por\r\n" + 
						"        <b>Adel'son - Vel'skii - Landis (AVL)</b>.\r\n" + 
						"    </p>\r\n" + 
						"</section>\r\n" +
						"<section>\r\n" +
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>size()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o número de entradas contidas na arvore de busca.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isEmpty()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna <b>true</b> se a arvore de busca estiver vazio ou <b>false</b> se não estiver.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>get(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Pesquisa por uma entrada que tenha a chave igual a <b>k</b>, caso encontre, retorna o valor contido\r\n" + 
						"                    na entrada, caso não encontre, retorna <b>null</b>.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>put(k, v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"					 <img src='"+ putavlimg +"'>\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>remove(k)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"					 <p><img src='"+ remavlimg +"'></p>\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>isBalanced()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna se um nodo tem o fator de balanceamento entre -1 e 1.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>rebalance(p)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Chamado para inserir e remover. Percorre de <b>p</b> até a raiz.\r\n" + 
						"                    Para cada nodo encontrado, recomputamos a sua <b>altura</b> e\r\n" + 
						"                    executamos a reestruturação trinode se desbalanceado.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>\r\n"
						,
						panel
				);
	}

	// Descrição do painel Grafos
	public static void descriptionGraph(JPanel panel) {
		setDescription(
				"<section>\r\n" + 
						"    <h1>Grafos</h1>\r\n" + 
						"</section>\r\n" + 
						"\r\n" + 
						"<section>\r\n" + 
						"    <h2>Definição</h2>\r\n" + 
						"    <p>\r\n" + 
						"        São discutidas três alternativas conhecidas, geralmente referidas como\r\n" +
						"		 estrutura de <b>lista de arestas, estrutura de lista de adjacência e matriz de\r\n" +
						"		 adjacência</b>.\r\n" + 
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						"        Nas três representações, usa-se uma coleção para armazenar os vértices do grafo.\r\n" +
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						" 		 A estrutura de <b>lista de arestas e a estrutura de lista de adjacência</b>\r\n" +
						"		 armazenam apenas as arestas realmente presentes no grafo, enquanto a\r\n" +
						"		 <b>matriz de adjacência</b> armazena uma posição para cada par de vértices (se\r\n" +
						"		 houver uma aresta entre eles ou não).\r\n" +
						"    </p>\r\n" + 
						"    <p>\r\n" + 
						" 		 Essa diferença faz com que a representação de <b>listas de arestas ou listas\r\n" +
						"		 de adjacências</b> use menos espaço de memória do que a representação de\r\n" +
						"		 <b>matriz de adjacência</b>.\r\n" +
						"    </p>\r\n" + 
						"</section>\r\n" +
						"<section>\r\n" +
						"    <table>\r\n" + 
						"        <tr class=\"header\">\r\n" + 
						"            <th>Operação</th>\r\n" + 
						"            <th>Função</th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>vertices()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável de todos os vértices do grafo.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>edges()</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção iterável de todas as arestas do grafo.\r\n" + 
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>incidentEdges(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna uma coleção das arestas incidentes sob o nodo <b>v</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>opposite(v, e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna o nodo final da aresta <b>e</b> oposto ao nodo <b>v</b>; um erro ocorre se <b>e</b> não é incidente a <b>v</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>endVertices(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Retorna um arranjo armazenando os vértices finais da aresta <b>e</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>areAdjacent(v, w)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Testa se os vértices <b>v</b> e <b>w</b> são adjacentes.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>replace(v, x)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Substitui o elemento armazenado no nodo <b>v</b> com <b>x</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>replace(e, x)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Substitui o elemento armazenado na aresta <b>e</b> com <b>x</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>insertVertex(x)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Insere e retorna um novo nodo armazenando o elemento <b>x</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>insertEdge(v, w, x)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Insere e retorna uma nova aresta não dirigida (<b>v</b>, <b>w</b>) e armazena o elemento <b>x</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"forte\">\r\n" + 
						"            <td>removeVertex(v)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove o vértice <b>v</b> e todas as arestas incidentes e retorna o elemento armazenado em <b>v</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr class=\"fraco\">\r\n" + 
						"            <td>removeEdge(e)</td>\r\n" + 
						"            <td>\r\n" + 
						"                <p>\r\n" + 
						"                    Remove a aresta <b>e</b> e retorna o elemento armazenado em <b>e</b>.\r\n" +
						"                </p>\r\n" + 
						"            </td>\r\n" + 
						"        </tr>\r\n" + 
						"    </table>\r\n" + 
						"</section>\r\n"
						,
						panel
				);
	}

	// Descrição do painel Sobre
	public static void descriptionAbout(JPanel panel) {
		setDescription(
				"    <style type=\"text/css\">\r\n" + 
						"        h1 {\r\n" + 
						"            font-size: xx-large;\r\n" + 
						"            text-align: center;\r\n" + 
						"        }\r\n" + 
						"        h2, p {\r\n" + 
						"             font-size: x-large;   \r\n" + 
						"        }\r\n" + 
						"    </style>\r\n" + 
						"    <h1>Sobre</h1>\r\n" + 
						"    <p>Esta aplicação tem o objetivo de mostrar os\r\n" + 
						"        <strong>Tipos Abstratos de Dados (TAD)</strong>\r\n" + 
						"        mais comuns e demonstrar algumas de suas operações básicas como:\r\n" + 
						"        <strong>Inserção, Remoção e Visualização.</strong>\r\n" + 
						"    </p>\r\n" + 
						"    <p>O projeto foi criado para adaptação criativa e especifica,\r\n" + 
						"        todas as estruturas podem ser melhoradas e reestruturadas para outros objetivos,\r\n" + 
						"        para mais detalhes de cada <b>TAD</b> encontre em: <b>com.types.structures</b>.\r\n" + 
						"    </p>\r\n" + 
						"    <p>A parte gráfica dessa aplicação foi construida baseada em uma\r\n" + 
						"        <b>Design Pattern</b> chamada <b>Builder</b> que consister em modularizar\r\n" + 
						"        classes do código em pedaços para junta-los posteriormente na classe principal\r\n" + 
						"    </p>\r\n" + 
						"    <br>\r\n" + 
						"    <section id=\"authors\">\r\n" + 
						"        <p>Autor: Ricardo de Oliveira Trovato</p>\r\n" + 
						"		 <p>Mais detalhes: https://github.com/devrictrovato/DataStructures </p>\r\n" +
						"		 <p>Portifolio: https://github.com/devrictrovato </p>\r\n" +
						"		 <p>Linkedin: https://www.linkedin.com/in/ricardo-de-oliveira-trovato/ </p>\r\n" +
						"    </section>\r\n" +
						"", 
						panel
				);
	}

	// Leitura de HTML/CSS nas descrições
	private static void setDescription(String content, JPanel panel) {
		layout.setConstraints(0, 0, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		layout.weightx = 3;
		layout.weighty = 1;

		desc = new JTextPane();
		desc.setEditable(false);
		desc.setBackground(new Color(244, 230, 255));
		desc.setContentType("text/html");
		desc.setText("<style>* {\r\n" + 
				"    font-family: sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body {\r\n" + 
				"    background-color: #E4F1F6;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1 {\r\n" + 
				"    text-align: center;\r\n" + 
				"    font-size: xx-large;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h2 {\r\n" + 
				"    font-size: x-large;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table {\r\n" + 
				"    border-spacing: 5px;\r\n" + 
				"    margin-left: -5px;\r\n" + 
				"    font-size: large;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"p {\r\n" + 
				"    font-size: large;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"th {\r\n" + 
				"    padding: 5px;\r\n" + 
				"    color: #ddb3ff;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td {\r\n" + 
				"    padding: 5px;\r\n" + 
				"    color: #333;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td p {\r\n" + 
				"    margin: 5px 0px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"th,\r\n" + 
				"td {\r\n" + 
				"    padding-left: 10px;\r\n" + 
				"    padding-right: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".header th {\r\n" + 
				"    background-color: #092834;\r\n" +
				"    color: #67AFCB;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".forte td {\r\n" + 
				"    background-color: #1A3E4C;\r\n" +
				"    color: #67AFCB;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".fraco td {\r\n" + 
				"    background-color: #347B98;\r\n" + 
				"    color: #67AFCB;\r\n" + 
				"}</style>" + content);

		JScrollPane scroll = new JScrollPane(desc);
		scroll.setBorder(null);
		scroll.setPreferredSize(desc.getPreferredSize());
		panel.add(scroll, layout);
	}

}
