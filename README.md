# Tic-Tac-Toe AI (Minimax - Java)

Bu proje, yapay zekâ rakibine karşı oynanan basit bir Tic-Tac-Toe (XOX) oyunudur. Yapay zekâ kısmında **Minimax algoritması** kullanılmıştır.

---

## Proje Hakkında

- Oyun Java dili ile geliştirilmiştir.
- Yapay zekâ, Minimax algoritması sayesinde optimal hamle yapar.
- Oyun terminal/console üzerinden çalışır.
- İki taraf da hatasız oynarsa oyun berabere biter.

## Yapay Zekâ Mantığı

Yapay zekâ, olası tüm hamleleri değerlendirir ve gelecekte oluşabilecek oyun durumlarını hesaplayarak en iyi hamleyi seçer.

Bu projede özellikle şu konuları anlamaya odaklandım:
- Minimax algoritması
- Recursive düşünme mantığı
- Oyun ağacı (game tree) yapısı

## Çalıştırma

```bash
javac TicTacToeAI.java
java TicTacToeAI
```

Oyun seni karşılayacak. 0-8 arası bir sayı girerek hamleni yap.

## Tahta

Tahta tek boyutlu bir dizidir; 9 hücreye 0-8 arası numaralar şöyle dağılır:

```
 0 | 1 | 2
-----------
 3 | 4 | 5
-----------
 6 | 7 | 8
```

## Algoritma: Minimax Nasıl Çalışır?

Bilgisayar her hamleyi yapmadan önce **tüm olası oyun ağacını** zihninde oynar ve en iyi sonucu veren hamleyi seçer.

### Skorlama

| Sonuç | Skor |
|:---:|:---:|
| O kazandı | `+1` |
| Berabere | `0` |
| X kazandı | `-1` |

Skorların simetrik olması (`-1, 0, +1`) Math.max/min fonksiyonlarının doğal çalışmasını sağlar.

### İki Oyuncu, Zıt Hedefler

- **Maximizing (O)** — skoru **büyütmeye** çalışır
- **Minimizing (X)** — skoru **küçültmeye** çalışır

Bilgisayar, "ben en yüksek skoru veririm, rakibim ise bana en kötüyü yapar" mantığıyla sırayla `max` ve `min` alır. Algoritmanın adı buradan gelir: **MIN-i-MAX**.

### Backtracking Deseni

Minimax her olası hamleyi gerçekten tahtaya koyup sonra geri alır:

```
1. Hamleyi dene      ->  board[i] = 'O';
2. Devamını hesapla  ->  int score = minimax(false);
3. Hamleyi geri al   ->  board[i] = ' ';
4. Skoru kaydet      ->  bestScore = Math.max(score, bestScore);
```

Geri alma (3. adım) kritiktir — yoksa zihinde denenen hamleler tahtada kalır.

## Sınıf Yapısı

| Metot | Açıklama |
|---|---|
| `printBoard()` | Tahtanın güncel halini konsola yazdırır |
| `checkWinner(char)` | Verilen oyuncunun kazanıp kazanmadığını kontrol eder |
| `isFull()` | Tahta dolu mu (beraberlik kontrolü için) |
| `minimax(boolean)` | Rekürsif Minimax — pozisyonun skorunu döner |
| `bestMove()` | Tüm boş hücreleri deneyip en iyi skorlu hamleyi seçer |
| `main()` | Oyun döngüsü, kullanıcı girişi ve oyun sonu kontrolü |

## Notlar

- Kullanıcı geçersiz bir hücre (dolu olan) seçerse program tekrar sorar.
- Klasör adında Türkçe karakter olması Windows + Java kombinasyonunda sorun çıkarabilir; ASCII karakterli bir yol kullanmak daha güvenli.

## Geliştirme Önerileri

- **Alpha-beta pruning** — gereksiz dalları atlayarak aramayı hızlandır
- **Derinlik bonusu** — `return 10 - depth` ile bilgisayarın "en hızlı kazanmayı" tercih etmesini sağla
- **GUI** — Swing veya JavaFX ile görsel arayüz ekle
- **Zorluk seviyesi** — kolay modda rastgele oyna, zor modda Minimax kullan

## Bu Projede Yardım Aldığım Kaynaklar

Bu proje öğrenme amaçlı yazılmıştır. Kodu kendim baştan sona yazmadım; **Anthropic'in Claude AI asistanından** önemli ölçüde yardım aldım. Süreç şöyle ilerledi:

- Algoritmanın temel iskeletini ve Minimax mantığını Claude ile birlikte kurguladık.
- Kodun bazı kısımlarını anlamadığımda (örneğin `winPositions` dizisinin mantığı, `-1, 0, +1` skorlamasının nedeni) Claude bana detaylı açıklamalar ve görsel anlatımlar sağladı.
- Kod yorumları ve bu README dosyası Claude ile birlikte yazıldı.
- Kararlar ve düzenlemeler benim tarafımdan onaylandı, ama metnin önemli bir kısmı AI tarafından üretildi.

Amacım algoritmayı **gerçekten anlamak**, sadece çalışan bir kod elde etmek değildi. Claude'u bir öğretmen gibi kullandım: kavramları sordum, açıklamalar aldım, kodu birlikte gözden geçirdim.

---

*Java • Minimax • Recursion + Backtracking*
