// 拡張機能のボタンがクリックされたときに、対象タブで extractAndCopyHTML 関数を実行
chrome.action.onClicked.addListener((tab) => {
  chrome.scripting.executeScript({
    target: { tabId: tab.id },
    function: extractAndCopyHTML
  }).catch(err => console.error(err));
});

// content script（実行されるスクリプト）からのメッセージを受け取る
chrome.runtime.onMessage.addListener((message, sender) => {
  const tabId = sender.tab ? sender.tab.id : null;
  if (!tabId) return;

  // 成功・失敗に応じたバッジのメッセージと色の変数
  const successMessage = "Copied";
  const successColor = "#4688F1";
  const errorMessage = "Error";
  const errorColor = "#FF0000";

  let badgeText = "";
  let badgeColor = "";

  if (message.action === "copied") {
    badgeText = successMessage;
    badgeColor = successColor;
  } else if (message.action === "copyError") {
    badgeText = errorMessage;
    badgeColor = errorColor;
  }

  // バッジテキストと背景色を設定
  chrome.action.setBadgeText({ text: badgeText, tabId });
  chrome.action.setBadgeBackgroundColor({ color: badgeColor, tabId });

  // 2秒後にバッジをクリア
  setTimeout(() => {
    chrome.action.setBadgeText({ text: "", tabId });
  }, 2000);
});

// ページ内のHTMLから必要な情報を抽出し、生成したHTMLをクリップボードへコピーする関数
function extractAndCopyHTML() {
  // 成功時・失敗時のメッセージ用アクション名
  const successAction = "copied";
  const errorAction = "copyError";

  // 1. sample-containerクラスを持つdivの中身を取得
  const sampleContainer = document.querySelector('.sample-container');
  const sampleContent = sampleContainer ? sampleContainer.innerHTML : '';

  // 2. headタグ内のtitleタグ（タグごと取得）を取得
  const titleElement = document.querySelector('head title');
  const titleTag = titleElement ? titleElement.outerHTML : '';

  // 最低限のHTML構造を生成（例：<html><head>…</head><body>…</body></html>）
  const resultHTML = `<html><head>${titleTag}</head><body>${sampleContent}</body></html>`;

  // クリップボードへコピー
  navigator.clipboard.writeText(resultHTML)
    .then(() => {
      // コピー成功時はバックグラウンドにメッセージを送信
      chrome.runtime.sendMessage({ action: successAction });
    })
    .catch(err => {
      console.error("クリップボードへのコピーに失敗しました:", err);
      // コピー失敗時はバックグラウンドにエラーメッセージを送信
      chrome.runtime.sendMessage({ action: errorAction });
    });
}
