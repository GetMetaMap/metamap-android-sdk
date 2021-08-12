# Testing ReadMe MarkDown

## Testing Code Tabs

[block:code]
{
  "codes": [
    {
      "code": "@Override\nprotected void onCreate(Bundle savedInstanceState) {\n    super.onCreate(savedInstanceState);\n\n    setContentView(R.layout.activity_main);\n    \n    ...\n\n    this.<MatiButton>findViewById(R.id.matiKYCButton).setParams(\n        \"CLIENT_ID\", \n        \"FLOW_ID\", \n        \"BUTTON_TITLE\", \n        METADATA);\n}",
      "language": "java",
      "name": "Go test"
    },
    {
      "code": "override fun onCreate(savedInstanceState: Bundle?) {\n    super.onCreate(savedInstanceState)\n\n    setContentView(R.layout.activity_main);\n\n    ...\n    \n    findViewById<MatiButton>(R.id.matiKYCButton).setParams(\n        \"CLIENT_ID\", \n        \"FLOW_ID\", \n        \"BUTTON_TITLE\", \n        METADATA)\n}\n\n",
      "language": "kotlin",
      "name": "Kotlin"
    }
  ]
}
[/block]
