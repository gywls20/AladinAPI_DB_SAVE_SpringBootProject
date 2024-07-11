알라딘 api의 정보를 개인 데이터 베이스저장하는 프로그램입니다.

저장하는 정보 예시<br>
{<br>
  "bookPk": 361,<br>
  "bookTitle": "혼자일 수 없다면 나아갈 수 없다 - 프리드리히 니체 아포리즘",<br>
  "bookAuthor": "프리드리히 니체 (지은이), 김욱 (편역)",<br>
  "bookPublisher": "포레스트북스",<br>
  "bookPublishDate": "2024-03-14",<br>
  "bookPrice": 17500,<br>
  "bookIsbn": "9791193506387",<br>
  "bookCategory": "인문학",<br>
  "coverImagePath": "https://image.aladin.co.kr/product/33556/67/cover/k472939677_1.jpg",<br>
  "bookTextPath": null,<br>
  "aladinLink": "http://www.aladin.co.kr/shop/wproduct.aspx?ItemId=335566789&amp;partner=openAPI&amp;start=api",<br>
  "bookPage": 260,<br>
  "bookContent": "니체는 평생 열네 권의 책을 썼고, 바그너를 비롯한 여러 사람들과 편지를 주고받았다. 『혼자일 수 없다면 나아갈 수 없다』는 그가 남긴 책들과 사후 발견된 편지, 일기, 메모, 미완성 유고 등에서 통찰과 조언을 담은 힘 있고 아름다운 문장들을 모아 엮은 책이다.",<br>
  "bookOriginalTitle": ""<br>
}<br>

* 알라딘 최신 등록 책 정보를 가져오며 만약 DB에 같은 책이 있을 경우 제외 후 저장합니다.
