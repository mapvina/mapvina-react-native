# mapvina-react-native: verification 04/10/2026

**Status: PUBLIC ANDROID INTEGRATION BLOCKED.**

main source `1.0.1`; npm latest `@mapvina-com/mapvina-react-native@1.0.2`.

Source baseline: `2c1a4f9d70b48b25e4f6e4e5b8adfc604c2320b0` (`origin/main` plus the sample/doc changes in this PR).

Audit only: no SDK API/version changes, tags, publishing or main merge.

## Blocker wrapper public

RN CLI và Expo đều compile public npm `1.0.2` thất bại vì import
`io.github.mapvina.android.plugins.annotation.*`, trong khi plugin AAR public
`1.0.0` chứa `com.mapvina.android.plugins.annotation.*`.
Nâng GeoJSON/Turf/Gestures riêng không chứng minh wrapper đã chạy được.
Không đổi imports hoặc bump/publish wrapper trong PR docs.

iOS sample public-package audit dừng tại `pod install --deployment` do lockfile
khác spec checksums; build/runtime iOS NOT TESTED. Native public SPM `1.0.0`
vẫn logo cũ. Root npm badge và link dùng đúng scope `@mapvina-com`.
Version trên source, npm, Maven và SPM phải được ghi riêng. Source TS/native
tests và new architecture runtime không được suy ra từ package install PASS.

## Evidence and acceptance boundary

[Cross-repository artifact and runtime audit](https://github.com/mapvina/mapvina-document-android/blob/codex/docs-verification-20261004/docs/verification/2026-10-04/README.md).

PASS applies only to the named checks. BLOCKED is a reproduced failure; NOT TESTED is not a pass.

## Separate follow-up

[Reproduced blocker issue](https://github.com/mapvina/mapvina-react-native/issues/18). SDK/infra fixes are outside this PR.
